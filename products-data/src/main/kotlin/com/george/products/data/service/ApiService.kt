package com.george.products.data.service

import com.george.network.provideRetrofit
import com.george.products.data.BuildConfig
import com.george.products.data.model.toListHomeFeedItemsDM
import com.george.products.domain.model.HomeFeedItemDM
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

internal class ApiService {

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        encodeDefaults = true
    }

    private val retrofit by lazy {
        provideRetrofit(BuildConfig.REST_API, BuildConfig.DEBUG).newBuilder().addConverterFactory(
            json.asConverterFactory(
                "application/json; charset=UTF8".toMediaType()
            )
        ).build()
    }

    private val service by lazy {
        retrofit.create(Service::class.java)
    }

    suspend fun loadHomeFeed(): Flow<List<HomeFeedItemDM>> = flow {
        emit(service.loadHomeFeed().toListHomeFeedItemsDM())
    }
}