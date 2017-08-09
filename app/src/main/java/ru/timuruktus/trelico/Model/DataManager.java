package ru.timuruktus.trelico.Model;

import android.util.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.timuruktus.trelico.POJO.Shop;
import ru.timuruktus.trelico.REST.BackendlessAPI;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static ru.timuruktus.trelico.MainPart.MainActivity.DEFAULT_TAG;
import static ru.timuruktus.trelico.REST.BackendlessAPI.BASE_URL;

public class DataManager implements IDataManager {



    private static final int LOAD_SHOPS_TIMEOUT = 10; // In seconds
    private static final int RETRY_COUNT = 3;
    private static Retrofit backendlessRetrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private static DataManager dataManager;


    public static DataManager getInstance(){
        if (dataManager != null){
            return dataManager;
        }else{
            dataManager = new DataManager();
            return dataManager;
        }
    }

    /*
    Only presenter can work with the error. Don't handle errors here.
     */
    @Override
    public Observable<List<Shop>> loadShopsFromWeb() {
        Log.d(DEFAULT_TAG, "Try to load from web");
        final IDatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        BackendlessAPI backendlessAPI = backendlessRetrofit.create(BackendlessAPI.class);
        Observable<List<Shop>> shopsList = backendlessAPI
                .listShops()
                .timeout(LOAD_SHOPS_TIMEOUT, TimeUnit.SECONDS)
                .retry(RETRY_COUNT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(shops -> {
                    databaseHelper.cacheShops(shops);
                    return shops;
                });

        return shopsList;
    }

    @Override
    public Observable<List<Shop>> loadShopsFromCache(Realm realm) {
        Log.d(DEFAULT_TAG, "Try to load from cache");
        final IDatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        return databaseHelper.getShops(realm);
    }


}
