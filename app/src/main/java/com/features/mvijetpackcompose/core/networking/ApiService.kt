package com.features.mvijetpackcompose.core.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    val BASE_URL = "https://www.freetestapi.com/api/v1/"

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: TestApi = getRetrofit().create(TestApi::class.java)
}