package com.features.mvijetpackcompose.domain.repository

import com.features.mvijetpackcompose.data.model.Animal

interface AppRespository {
    suspend fun getAnimal(): List<Animal>
}