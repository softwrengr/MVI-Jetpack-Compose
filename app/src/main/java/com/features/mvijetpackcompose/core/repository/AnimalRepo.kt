package com.features.mvijetpackcompose.core.repository

import com.features.mvijetpackcompose.core.networking.TestApi

class AnimalRepo(private val api: TestApi) {
    suspend fun getAnimal() = api.getAnimals()
}