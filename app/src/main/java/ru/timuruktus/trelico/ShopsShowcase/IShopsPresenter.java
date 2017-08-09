package ru.timuruktus.trelico.ShopsShowcase;

import ru.timuruktus.trelico.POJO.Shop;

public interface IShopsPresenter {


    void loadShops();

    void onRefreshButClick();
    void onShopClick(Shop shop);

    void onCreateView();
    void onDestroyView();

}
