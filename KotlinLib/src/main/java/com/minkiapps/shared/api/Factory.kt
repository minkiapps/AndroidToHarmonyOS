package com.minkiapps.shared.api

import com.minkiapps.shared.JOKE_BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

fun createApiService() : ApiService {
    val client = OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .build()
    val retrofit = Retrofit.Builder()
        .baseUrl(JOKE_BASE_URL)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create()).client(client)
        .build()
    return retrofit.create(ApiService::class.java)
}