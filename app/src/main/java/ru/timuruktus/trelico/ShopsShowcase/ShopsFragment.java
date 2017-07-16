package ru.timuruktus.trelico.ShopsShowcase;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import ru.timuruktus.trelico.POJO.Shop;
import ru.timuruktus.trelico.R;

public class ShopsFragment extends Fragment implements IShopsFragment {


    private View rootView;
    private Context context;
    private IShopsPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(
                R.layout.shops_fragment, container, false);
        context = rootView.getContext();
        presenter = new ShopsPresenter(this);
        presenter.loadShops();

        return rootView;
    }

    @Override
    public void showShops(List<Shop> shops) {

    }

    @Override
    public void showProgressIndicator(boolean show) {

    }

    @Override
    public void showError() {

    }
}
