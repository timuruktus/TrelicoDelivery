package ru.timuruktus.trelico.ShopsShowcase;

import java.util.List;

import ru.timuruktus.trelico.POJO.Shop;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ShopsPresenter implements IShopsPresenter {

    private IShopsFragment fragment;
    private IShopsModel model;


    ShopsPresenter(IShopsFragment fragment) {
        this.fragment = fragment;
        model = ShopsModel.getInstance();
    }


    @Override
    public void loadShops() {
        fragment.showProgressIndicator(true);
        model.loadShops().toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Shop>>() {
                    @Override
                    public void onCompleted() {
                        fragment.showProgressIndicator(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        fragment.showProgressIndicator(false);
                        fragment.showError();
                    }

                    @Override
                    public void onNext(List<Shop> shopsList) {
                        fragment.showShops(shopsList);
                    }
                });
    }
}
