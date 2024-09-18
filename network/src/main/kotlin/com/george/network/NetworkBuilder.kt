package com.george.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

private var retrofit: Retrofit? = null
private var okHttp: OkHttpClient? = null

fun provideRetrofit(restApiUrl: String, isDebug: Boolean): Retrofit =
    retrofit ?: initRetrofit(restApiUrl, isDebug)

private fun initRetrofit(restApiUrl: String, isDebug: Boolean) =
    Retrofit.Builder().client(provideOkHttp(isDebug)).baseUrl(restApiUrl).build()
        .also { retrofit = it }

private fun provideOkHttp(isDebug: Boolean): OkHttpClient = okHttp ?: initOkHttp(isDebug)

private fun initOkHttp(isDebug: Boolean): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor().setLevel(
        when {
            isDebug -> HttpLoggingInterceptor.Level.BASIC
            else -> HttpLoggingInterceptor.Level.NONE
        }
    )
    return OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES).readTimeout(1, TimeUnit.MINUTES)
        .retryOnConnectionFailure(true).addInterceptor(loggingInterceptor)
        .build().also { okHttp = it }
}