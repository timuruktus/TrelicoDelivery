package ru.timuruktus.trelico.Model;

import java.util.List;

import io.realm.Realm;
import ru.timuruktus.trelico.POJO.Shop;
import rx.Observable;

public interface IDatabaseHelper {

    void cacheShop(Shop shop);
    void cacheShops(List<Shop> shops);
    Observable<List<Shop>> getShops(Realm realm);
}
