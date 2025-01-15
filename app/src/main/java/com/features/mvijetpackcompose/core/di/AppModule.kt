package com.features.mvijetpackcompose.core.di

import com.features.mvijetpackcompose.data.RemoteApiService
import com.features.mvijetpackcompose.domain.repository.AppRespository
import com.features.mvijetpackcompose.data.respository.AppRespositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideCommonRepository(apiService: RemoteApiService): AppRespository {
        return AppRespositoryImp(apiService)
    }
}