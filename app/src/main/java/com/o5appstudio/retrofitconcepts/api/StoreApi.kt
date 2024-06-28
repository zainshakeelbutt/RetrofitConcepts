package com.o5appstudio.retrofitconcepts.api

import com.o5appstudio.retrofitconcepts.models.StoreData
import retrofit2.Response
import retrofit2.http.GET

interface StoreApi {

    @GET("/products")
    suspend fun getProducts() : Response<List<StoreData>>

}