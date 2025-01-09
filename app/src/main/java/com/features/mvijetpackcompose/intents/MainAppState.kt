package com.features.mvijetpackcompose.intents

import com.features.mvijetpackcompose.model.Animal

sealed class MainAppState {

    object Idle: MainAppState()
    object Loading: MainAppState()
    data class DataState(val animal: List<Animal>): MainAppState()
    data class ErrorState(val error: String?): MainAppState()
}