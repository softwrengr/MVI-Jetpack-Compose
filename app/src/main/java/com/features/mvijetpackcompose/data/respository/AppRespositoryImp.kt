package com.features.mvijetpackcompose.data.respository

import com.features.mvijetpackcompose.data.RemoteApiService
import com.features.mvijetpackcompose.domain.repository.AppRespository
import javax.inject.Inject

class AppRespositoryImp @Inject constructor(
    private val api: RemoteApiService
): AppRespository {

    override suspend fun getAnimal() = api.getAnimals()
}