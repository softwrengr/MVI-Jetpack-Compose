package com.features.mvijetpackcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.features.mvijetpackcompose.core.networking.TestApi
import com.features.mvijetpackcompose.core.repository.AnimalRepo

class ViewModelFactory(private val api: TestApi): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(AnimalRepo(api)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}