package com.o5appstudio.retrofitconcepts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.o5appstudio.retrofitconcepts.models.StoreData
import com.o5appstudio.retrofitconcepts.repository.StoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(private val repository: StoreRepository) : ViewModel() {

    init {
        viewModelScope.launch {
            fetchData()

        }
    }
    suspend fun fetchData(){
        repository.getProducts()
    }


    val productsList : LiveData<List<StoreData>>
        get() = repository.productsList

}