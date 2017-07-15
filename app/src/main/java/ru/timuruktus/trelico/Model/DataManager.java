package ru.timuruktus.trelico.Model;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.timuruktus.trelico.POJO.Shop;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class DataManager implements IDataManager {

    //    https://api.backendless.com/<application-id>/<api-key>/<operation-specific-path>
    private static final String APP_ID = "195764CA-FB57-8617-FFD8-2729F0D17D00";
    private static final String API_KEY = "00D321C7-38B7-9896-FFDF-BFE39D1AAF00";
    private static final String BASE_URL = "https://api.backendless.com/" + APP_ID + "/" + API_KEY +"/";
    private Retrofit retrofit;

    @Override
    public void setupRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private boolean isRetrofitInit(){
        return retrofit != null;
    }

    @Override
    public Observable<List<Shop>> loadShops() {
        if(!isRetrofitInit()){
            setupRetrofit();
            loadShops();
        }
        BackendlessAPI backendlessAPI = retrofit.create(BackendlessAPI.class);
        Observable<List<Shop>> shopsList = backendlessAPI
                .listShops()
                .subscribeOn(Schedulers.io())
                .concatMap(new Func1<List<Shop>, Observable<Shop>>() {
                    @Override
                    public Observable<Shop> call(List<Shop> shops) {
                        return mDatabaseHelper.savePosts(shops);
                    }
                });
        return shopsList;
    }



}
