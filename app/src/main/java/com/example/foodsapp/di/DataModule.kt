package com.example.foodsapp.di

import com.example.foodsapp.data.FoodService
import com.example.foodsapp.data.util.Constants
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideFoodService(): FoodService = Retrofit.Builder()
        .baseUrl(Constants.API_BASE_URL)
        .addConverterFactory(defaultJson.asConverterFactory("application/json".toMediaType()))
        .build()
        .create()

}

private val defaultJson = Json { ignoreUnknownKeys = true }
