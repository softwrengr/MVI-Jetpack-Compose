package com.features.mvijetpackcompose.data

import com.features.mvijetpackcompose.data.model.Animal
import retrofit2.http.GET

interface RemoteApiService {

    @GET("animals")
    suspend fun getAnimals(): List<Animal>
}