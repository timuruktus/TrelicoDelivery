package ru.timuruktus.trelico.Model;

import ru.timuruktus.trelico.POJO.Shop;
import rx.Observable;

public interface IDatabaseHelper {

    void cacheShop(Shop shop);
    Observable<Shop> getShops();
}
