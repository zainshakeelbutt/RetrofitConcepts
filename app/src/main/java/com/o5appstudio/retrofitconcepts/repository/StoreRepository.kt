package com.o5appstudio.retrofitconcepts.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.o5appstudio.retrofitconcepts.api.StoreApi
import com.o5appstudio.retrofitconcepts.models.StoreData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import javax.inject.Inject

class StoreRepository @Inject constructor(private val storeApi: StoreApi){

    private val _productsList = MutableLiveData<List<StoreData>>(emptyList())
    val productsList : LiveData<List<StoreData>>
        get() = _productsList


    suspend fun getProducts(){
        try {
            val result =  storeApi.getProducts()
            if(result.isSuccessful && result.body() != null){
                _productsList.postValue(result.body())
            }
        }
        catch (e : Exception){
           Log.d("TAG", e.toString())
        }

    }



}