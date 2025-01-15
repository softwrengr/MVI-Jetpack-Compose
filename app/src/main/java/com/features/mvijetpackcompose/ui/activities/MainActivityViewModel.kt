package com.features.mvijetpackcompose.ui.activities

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.features.mvijetpackcompose.domain.repository.AppRespository
import com.features.mvijetpackcompose.intents.MainAppIntent
import com.features.mvijetpackcompose.intents.MainAppState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val animalRepo: AppRespository
): ViewModel() {

    val userIntent = Channel<MainAppIntent>(Channel.UNLIMITED)
    val state = mutableStateOf<MainAppState>(MainAppState.Idle)

    init {
        handleUserIntent()
    }

    private fun handleUserIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect { collector ->
                when(collector) {
                 is MainAppIntent.FetchAnimal -> fetchAnimal()
                }
            }
        }
    }

    private fun fetchAnimal() {
        viewModelScope.launch {
            state.value = MainAppState.Loading
            state.value = try {
                MainAppState.DataState(animalRepo.getAnimal())
            } catch (e: Exception) {
                MainAppState.ErrorState(e.localizedMessage)
            }
        }
    }
}