package com.o5appstudio.retrofitconcepts.api

sealed class ApiResponse<T>(val data : T? = null, val errorMsg : String? = null){

    class Loading<T>: ApiResponse<T>()
    class Success<T>(data: T? = null) : ApiResponse<T>(data = data)
    class Failure<T>(errorMessage : String): ApiResponse<T>(errorMsg = errorMessage )

}