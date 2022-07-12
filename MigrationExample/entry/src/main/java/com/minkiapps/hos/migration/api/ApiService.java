package com.minkiapps.hos.migration.api;

import com.minkiapps.shared.model.Joke;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiService {

    @GET("jokes/random")
    @Headers("Content-Type: application/json;charset=UTF-8")
    Single<Joke> fetchJokes();
}
