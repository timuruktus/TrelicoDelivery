package ru.timuruktus.trelico.ShopPart;

import android.app.Fragment;

import ru.timuruktus.trelico.POJO.Shop;

public class ShopFragment extends Fragment {


    private Shop shop;

    public static ShopFragment getInstance(Shop shop){
        ShopFragment shopFragment = new ShopFragment();
        shopFragment.shop = shop;
        return shopFragment;
    }
}
