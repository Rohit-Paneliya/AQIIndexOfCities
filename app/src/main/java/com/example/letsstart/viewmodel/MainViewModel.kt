package com.example.letsstart.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letsstart.data.response.AQIResponse
import com.example.letsstart.usecase.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainUseCase: MainUseCase): ViewModel() {

    private val _viewState = MutableLiveData<AQIResponse>()
    val viewState: LiveData<AQIResponse> = _viewState

    fun getAllCitiesWithAQIInfo() {
        viewModelScope.launch {
            val response = mainUseCase.getAllCitiesInfoWithAQI()
            _viewState.value = response
        }
    }

//    val TAG = "-----------MainViewModel"
//
//    private val _socketStatus = MutableLiveData(false)
//    val socketStatus: LiveData<Boolean> = _socketStatus
//
//    private val _messages = MutableLiveData<Pair<Boolean, String>>()
//    val messages: LiveData<Pair<Boolean, String>> = _messages
//
//    fun addMessage(message: Pair<Boolean, String>) = viewModelScope.launch(Dispatchers.Main) {
//        if (_socketStatus.value == true) {
//            _messages.value = message
//        }
//    }
//
//    fun setStatus(status: Boolean) = viewModelScope.launch(Dispatchers.Main) {
//        _socketStatus.value = status
//    }
}