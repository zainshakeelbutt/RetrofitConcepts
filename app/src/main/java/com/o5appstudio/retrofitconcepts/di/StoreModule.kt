package com.o5appstudio.retrofitconcepts.di

import android.provider.SyncStateContract.Constants
import com.o5appstudio.retrofitconcepts.api.StoreApi
import com.o5appstudio.retrofitconcepts.utils.Consts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class StoreModule {
    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesStoreApi(retrofit: Retrofit) : StoreApi{
        return retrofit.create(StoreApi::class.java)
    }

}