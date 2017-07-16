package ru.timuruktus.trelico.Model;

import java.util.List;

import ru.timuruktus.trelico.POJO.Shop;
import rx.Observable;

public interface IDataManager {

    Observable<Shop> loadShopsFromWeb();
    Observable<Shop> loadShopsFromCache();
}
