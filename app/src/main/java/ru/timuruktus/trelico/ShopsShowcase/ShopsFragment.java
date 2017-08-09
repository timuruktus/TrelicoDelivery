package ru.timuruktus.trelico.ShopsShowcase;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ru.timuruktus.trelico.POJO.Shop;
import ru.timuruktus.trelico.R;

public class ShopsFragment extends Fragment implements IShopsFragment {


    private View rootView;
    private Context context;
    IShopsPresenter presenter;
    private ImageView refreshIcon;

    public static ShopsFragment getInstance(){
        return new ShopsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(
                R.layout.shops_fragment, container, false);
        context = rootView.getContext();
        presenter = new ShopsPresenter(this);
        presenter.onCreateView();
        presenter.loadShops();
        refreshIcon = (ImageView) rootView.findViewById(R.id.refreshIcon);
        refreshIcon.setOnClickListener(v -> presenter.onRefreshButClick());
        return rootView;
    }

    @Override
    public void showShops(List<Shop> shops) {
        ShopsAdapter shopsAdapter = new ShopsAdapter(context, shops, this);
        ListView lvMain = (ListView) rootView.findViewById(R.id.shopsList);
        lvMain.setAdapter(shopsAdapter);
    }

    @Override
    public void showProgressIndicator(boolean show) {
        RelativeLayout loadingLayout = (RelativeLayout) rootView.findViewById(R.id.loadingLayout);
        if(show){
            loadingLayout.setVisibility(View.VISIBLE);
        }else{
            loadingLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(boolean show) {
        RelativeLayout errorLayout = (RelativeLayout) rootView.findViewById(R.id.errorLayout);
        if(show){
            errorLayout.setVisibility(View.VISIBLE);
        }else{
            errorLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public void showMessageNoInternetConnection() {
        Toast.makeText(context, R.string.error_loading_shops, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        presenter.onDestroyView();
        super.onDestroyView();
    }
}
