package ru.timuruktus.trelico.POJO;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ShopGeoPoint extends RealmObject {


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Required
    private double lat;
    @Required
    private double lng;
    @PrimaryKey
    private String objectId;


    public ShopGeoPoint(double lat, double lng, String objectId) {
        this.lat = lat;
        this.lng = lng;
        this.objectId = objectId;
    }

    public ShopGeoPoint() {
    }
}
