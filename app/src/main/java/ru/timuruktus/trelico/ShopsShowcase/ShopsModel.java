package ru.timuruktus.trelico.ShopsShowcase;

import ru.timuruktus.trelico.Model.DataManager;
import ru.timuruktus.trelico.POJO.Shop;
import rx.Observable;

public class ShopsModel implements IShopsModel {


    public static ShopsModel getInstance(){
        return new ShopsModel();
    }

    @Override
    public Observable<Shop> loadShops() {
        return DataManager.getInstance().loadShopsFromWeb();
    }
}
