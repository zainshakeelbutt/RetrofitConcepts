package com.o5appstudio.retrofitconcepts.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.o5appstudio.retrofitconcepts.api.ApiResponse
import com.o5appstudio.retrofitconcepts.api.StoreApi
import com.o5appstudio.retrofitconcepts.models.StoreData
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

class StoreRepository2 @Inject constructor(private val storeApi: StoreApi){

//    private val _productsList = MutableStateFlow<List<StoreData>>(emptyList())
//    val productsList : StateFlow<List<StoreData>>
//        get() = _productsList


    suspend fun getProds() : StateFlow<ApiResponse<List<StoreData>>>{
         val products = MutableStateFlow<ApiResponse<List<StoreData>>>(ApiResponse.Loading())

        try {
            val result =  storeApi.getProducts()

            if(result.isSuccessful){
                result.body()?.let {
                    products.emit(ApiResponse.Success(it))
                }
            } else{
                products.emit(ApiResponse.Failure("Error"))
            }
        }
        catch (e:Exception){
            products.emit(ApiResponse.Failure("Error"))
        }


         return products
     }



}