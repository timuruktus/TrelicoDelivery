package ru.timuruktus.trelico.ShopsShowcase;

import ru.timuruktus.trelico.POJO.Shop;
import rx.Observable;

public interface IShopsModel {

    Observable<Shop> loadShops();
}
