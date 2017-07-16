package ru.timuruktus.trelico.ShopsShowcase;

import java.util.List;

import ru.timuruktus.trelico.POJO.Shop;

public interface IShopsFragment {


    void showShops(List<Shop> shops);
    void showProgressIndicator(boolean show);
    void showError();
}
