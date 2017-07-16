package ru.timuruktus.trelico.ShopsShowcase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ru.timuruktus.trelico.POJO.Shop;
import ru.timuruktus.trelico.R;

import static ru.timuruktus.trelico.REST.BackendlessAPI.IMAGES_URL;

public class ShopAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater lInflater;
    private ArrayList<Shop> shops;

    ShopAdapter(Context context, ArrayList<Shop> shops) {
        this.context = context;
        this.shops = shops;
        lInflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

        Shop shop = getShop(position);

        ((TextView) view.findViewById(R.id.shopName)).setText(shop.getName());
        ((TextView) view.findViewById(R.id.numOfShops)).setText(shop.getCoordinates().size());
        ((TextView) view.findViewById(R.id.shopType)).setText(shop.getType());
//        ((ImageView) view.findViewById(R.id.ivImage)).setImageResource(shop.image);
        Picasso.with(context).load(IMAGES_URL + shop.getImageUrl());
        return view;
    }

    private Shop getShop(int position) {
        return ((Shop) getItem(position));
    }
}
