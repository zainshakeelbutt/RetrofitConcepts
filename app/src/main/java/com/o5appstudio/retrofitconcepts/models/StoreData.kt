package com.o5appstudio.retrofitconcepts.models

data class StoreData(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)