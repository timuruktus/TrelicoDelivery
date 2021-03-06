package ru.timuruktus.trelico.POJO;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ShopGeoPoint extends RealmObject {


    public ShopGeoPoint(double lat, double lng, String street, String objectId) {
        this.lat = lat;
        this.lng = lng;
        this.street = street;
        this.objectId = objectId;
    }


    public ShopGeoPoint() {
    }

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    private double lat;
    private double lng;
    @Required
    private String street;
    @PrimaryKey
    private String objectId;


}
