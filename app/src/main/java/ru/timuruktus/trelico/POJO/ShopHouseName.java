package ru.timuruktus.trelico.POJO;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ShopHouseName extends RealmObject {


    @Required
    private String house;
    @PrimaryKey
    @Required
    private String objectId;

    public ShopHouseName() {
    }

    public ShopHouseName(String house, String objectId) {
        this.house = house;
        this.objectId = objectId;
    }

    public String getHouse() {
        return house;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
