package ru.timuruktus.trelico.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.timuruktus.trelico.POJO.Shop;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static ru.timuruktus.trelico.MainPart.MainActivity.DEFAULT_TAG;
import static ru.timuruktus.trelico.MainPart.MainActivity.TESTING_TAG;

public class DatabaseHelper implements IDatabaseHelper {

    private Realm realm;

    public static IDatabaseHelper getInstance() {
        return new DatabaseHelper();
    }

    @Override
    public void cacheShop(final Shop shop) throws NullPointerException {
        Realm realm = Realm.getDefaultInstance();
        Log.d(DEFAULT_TAG, "Shop is cached");
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.copyToRealmOrUpdate(shop);
            }
        });
        realm.close();
    }

    @Override
    public void cacheShops(List<Shop> shops) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                for(Shop shop : shops) {
                    bgRealm.copyToRealmOrUpdate(shop);
                }
            }
        });
        realm.close();
    }

    @Override
    public Observable<List<Shop>> getShops(Realm realm) {

        Log.d(TESTING_TAG, "We are in getShops() in DatabaseHelper ");
        RealmResults<Shop> results = realm.where(Shop.class)
                .findAll();
        Log.d(DEFAULT_TAG, "Cache size is " + results.size());
        return Observable.from(results).toList();
    }


}
