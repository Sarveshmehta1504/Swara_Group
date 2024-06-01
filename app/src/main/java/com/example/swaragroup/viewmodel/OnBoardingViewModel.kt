package com.example.swaragroup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swaragroup.data.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val repository: DataStoreRepository
):ViewModel(){
    fun saveOnBoardingState(complete: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveOnBoardingState(completed = complete)
        }
    }

}