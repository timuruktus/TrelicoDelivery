package ru.timuruktus.trelico.Model;

import android.util.Log;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.timuruktus.trelico.POJO.Shop;
import rx.Observable;
import rx.functions.Func1;

import static ru.timuruktus.trelico.MainPart.MainActivity.TESTING_TAG;

public class DatabaseHelper implements IDatabaseHelper {

    private Realm realm;


    private DatabaseHelper(Realm realm) {
        this.realm = realm;
    }

    public static IDatabaseHelper getInstance() {
        return new DatabaseHelper(Realm.getDefaultInstance());
    }

    @Override
    public void cacheShop(final Shop shop) throws NullPointerException {
        if(realm == null){
            throw new NullPointerException("Realm didn't init. Use getInstance() to get DatabaseHelper");
        }
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.copyToRealm(shop);
            }
        });
    }

    @Override
    public Observable<Shop> getShops() {
        RealmResults<Shop> results = realm.where(Shop.class)
                .findAllAsync();
        return Observable.from(results);
    }


}
