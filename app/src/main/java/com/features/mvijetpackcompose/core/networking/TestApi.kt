package com.features.mvijetpackcompose.core.networking

import com.features.mvijetpackcompose.model.Animal
import retrofit2.http.GET

interface TestApi {

    @GET("animals")
    suspend fun getAnimals(): List<Animal>
}