package ru.timuruktus.trelico.Model;

import java.util.List;

import io.realm.Realm;
import ru.timuruktus.trelico.POJO.Shop;
import rx.Observable;

public interface IDataManager {

    Observable<List<Shop>> loadShopsFromWeb();
    Observable<List<Shop>> loadShopsFromCache(Realm realm);
}
