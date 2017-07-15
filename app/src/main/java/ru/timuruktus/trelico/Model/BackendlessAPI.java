package ru.timuruktus.trelico.Model;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.timuruktus.trelico.POJO.Shop;
import rx.Observable;

public interface BackendlessAPI {

    @GET("data/Shop")
    Observable<List<Shop>> listShops();



}
