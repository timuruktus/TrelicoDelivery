package ru.timuruktus.trelico.ShopsShowcase;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import ru.timuruktus.trelico.Model.DataManager;
import ru.timuruktus.trelico.POJO.Shop;
import ru.timuruktus.trelico.ShopPart.ShopFragment;
import ru.timuruktus.trelico.Utils.FragmentChanger;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static ru.timuruktus.trelico.MainPart.MainActivity.DEFAULT_TAG;
import static ru.timuruktus.trelico.MainPart.MainActivity.TESTING_TAG;

public class ShopsPresenter implements IShopsPresenter {

    private IShopsFragment fragment;
    private DataManager dataManager;
    private Realm realm;
    private static int fragmentOpens = 0;


    ShopsPresenter(IShopsFragment fragment) {
        this.fragment = fragment;
        dataManager = DataManager.getInstance();
    }


    @Override
    public void loadShops() {
        fragment.showError(false);
        if(fragmentOpens > 1){
            loadShopsFromCache();
            return;
        }
        fragmentOpens++;
        fragment.showProgressIndicator(true);
        dataManager.loadShopsFromWeb()
                .subscribe(new Observer<List<Shop>>() {
                    @Override
                    public void onCompleted() {
                        fragment.showProgressIndicator(false);
                    }

                    @Override
                    public void onError(Throwable e) {
//                        e.printStackTrace();
                        Log.d(TESTING_TAG, "onError() in loadShops()");
                        fragment.showMessageNoInternetConnection();
                        loadShopsFromCache();
                    }

                    @Override
                    public void onNext(List<Shop> shopsList) {
                        fragment.showShops(shopsList);
                    }
                });
    }

    @Override
    public void onRefreshButClick() {
        loadShops();
    }

    @Override
    public void onShopClick(Shop shop) {
        FragmentChanger.getInstance()
                .setFragment(ShopFragment.getInstance(shop))
                .needAddToBackStack(true)
                .changeFragment();
    }

    @Override
    public void onCreateView() {
        if(realm == null){
            realm = Realm.getDefaultInstance();
        }
    }

    @Override
    public void onDestroyView() {
        if(realm != null){
            realm.close();
        }
    }

    private void loadShopsFromCache(){
        dataManager.loadShopsFromCache(realm)
                .subscribe(new Observer<List<Shop>>() {
                    @Override
                    public void onCompleted() {
                        fragment.showProgressIndicator(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        fragment.showProgressIndicator(false);
                        fragment.showError(true);
                        Log.d(TESTING_TAG, "onError() in loadShopsFromCache()");
                    }

                    @Override
                    public void onNext(List<Shop> shopsList) {
                        Log.d(TESTING_TAG, "onNext() in loadShopsFromCache()");
                        if (shopsList.size() == 0) {
                            onError(new Throwable("Empty cache"));
                        }else {
                            fragment.showShops(shopsList);
                        }
                    }
                });
    }
}
