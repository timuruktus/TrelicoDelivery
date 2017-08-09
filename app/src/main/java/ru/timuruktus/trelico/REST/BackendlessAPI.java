package ru.timuruktus.trelico.REST;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.timuruktus.trelico.POJO.Shop;
import rx.Observable;

public interface BackendlessAPI {

    //    https://api.backendless.com/<application-id>/<api-key>/<operation-specific-path>
    String APP_ID = "195764CA-FB57-8617-FFD8-2729F0D17D00";
    String API_KEY = "00D321C7-38B7-9896-FFDF-BFE39D1AAF00";
    String BASE_URL = "https://api.backendless.com/" + APP_ID + "/" + API_KEY +"/";
    String IMAGES_FOLDER = "shops_images";
    String IMAGES_URL = BASE_URL + "files/" + IMAGES_FOLDER + "/";

    @GET("data/Shop")
    Observable<List<Shop>> listShops();


}
