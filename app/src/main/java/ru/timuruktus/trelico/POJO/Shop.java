package ru.timuruktus.trelico.POJO;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Shop extends RealmObject {

    public Shop() {
    }

    public Shop(RealmList<ShopGeoPoint> coordinates, String name, String objectId, String imageUrl,
                String imagePath, String description, String type) {
        this.coordinates = coordinates;
        this.name = name;
        this.objectId = objectId;
        this.imageUrl = imageUrl;
        this.imagePath = imagePath;
        this.description = description;
        this.type = type;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    private RealmList<ShopGeoPoint> coordinates;
    @Required
    private String name;
    @Required
    @PrimaryKey
    private String objectId;
    private String description;
    @Required
    private String imageUrl;
    private String imagePath;
    private String type;



}
