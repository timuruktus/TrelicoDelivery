package ru.timuruktus.trelico.POJO;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Shop extends RealmObject {


    public RealmList<ShopHouseName> getAddresses() {
        return addresses;
    }

    public void setAddresses(RealmList<ShopHouseName> addresses) {
        this.addresses = addresses;
    }

    public RealmList<ShopGeoPoint> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(RealmList<ShopGeoPoint> coordinates) {
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    private RealmList<ShopHouseName> addresses;
    private RealmList<ShopGeoPoint> coordinates;
    @Required
    private String name;
    @Required
    @PrimaryKey
    private String objectId;

    public Shop() {
    }

    public Shop(RealmList<ShopHouseName> addresses, RealmList<ShopGeoPoint> coordinates, String name, String objectId) {
        this.addresses = addresses;
        this.coordinates = coordinates;
        this.name = name;
        this.objectId = objectId;
    }
}
