package com.o5appstudio.retrofitconcepts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.o5appstudio.retrofitconcepts.api.ApiResponse
import com.o5appstudio.retrofitconcepts.models.StoreData
import com.o5appstudio.retrofitconcepts.repository.StoreRepository
import com.o5appstudio.retrofitconcepts.repository.StoreRepository2
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoreViewModel2 @Inject constructor(private val repository: StoreRepository2) : ViewModel() {

        private val _productsList = MutableStateFlow<ApiResponse<List<StoreData>>>(ApiResponse.Loading())
    val productsList : StateFlow<ApiResponse<List<StoreData>>>
        get() = _productsList

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            repository.getProds()
                .collect{
                    _productsList.value = it
                }
        }
    }


}