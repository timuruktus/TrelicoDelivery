package ru.timuruktus.trelico.ShopsShowcase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import ru.timuruktus.trelico.POJO.Shop;
import ru.timuruktus.trelico.R;

import static ru.timuruktus.trelico.REST.BackendlessAPI.IMAGES_URL;

public class ShopsAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater lInflater;
    private List<Shop> shops;
    private ShopsFragment shopsFragment;

    ShopsAdapter(Context context, List<Shop> shops, ShopsFragment shopsFragment) {
        this.context = context;
        this.shops = shops;
        lInflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.shopsFragment = shopsFragment;
    }

    @Override
    public int getCount() {
        return shops.size();
    }

    @Override
    public Object getItem(int position) {
        return shops.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.shop_closed, parent, false);
        }
        final Shop shop = getShop(position);

        view.setOnClickListener(v -> shopsFragment.presenter.onShopClick(shop));

        ((TextView) view.findViewById(R.id.shopName)).setText(shop.getName());
        ((TextView) view.findViewById(R.id.numOfShops)).setText(String.valueOf(shop.getCoordinates().size()));
        ((TextView) view.findViewById(R.id.shopType)).setText(shop.getType());
        ImageView shopPreview = (ImageView) view.findViewById(R.id.shopPreview);
        Glide.with(shopsFragment)
                .load(IMAGES_URL + shop.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(shopPreview);
        return view;
    }

    private Shop getShop(int position) {
        return ((Shop) getItem(position));
    }

    public List<Shop> getAllShops(){
        return shops;
    }
}
