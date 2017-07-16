package ru.timuruktus.trelico.Model;

import java.util.concurrent.TimeUnit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.timuruktus.trelico.POJO.Shop;
import ru.timuruktus.trelico.REST.BackendlessAPI;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static ru.timuruktus.trelico.REST.BackendlessAPI.BASE_URL;

public class DataManager implements IDataManager {



    private static final int LOAD_SHOPS_TIMEOUT = 10; // In seconds
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
    public Observable<Shop> loadShopsFromWeb() {
        final IDatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        BackendlessAPI backendlessAPI = backendlessRetrofit.create(BackendlessAPI.class);
        Observable<Shop> shopsList = backendlessAPI
                .listShops()
                .timeout(LOAD_SHOPS_TIMEOUT, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .map(new Func1<Shop, Shop>() {
                    /*
                    Here we caching our shops in DB
                     */
                    @Override
                    public Shop call(Shop shop) {
                        databaseHelper.cacheShop(shop);
                        return shop;
                    }
                });

        return shopsList;
    }

    @Override
    public Observable<Shop> loadShopsFromCache() {
        final IDatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        return databaseHelper.getShops();
    }


}
