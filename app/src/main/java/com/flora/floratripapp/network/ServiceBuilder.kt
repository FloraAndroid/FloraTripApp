package com.flora.floratripapp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val BASE_URL="https://cdn.theculturetrip.com/home-assignment/"
    private val okHttp= OkHttpClient.Builder()
    private val builder= Retrofit.Builder().baseUrl(BASE_URL).
    addConverterFactory(GsonConverterFactory.create()).client(okHttp.build())
    private val retrofit = builder.build()

    public fun <T> buildService(serviceType:Class<T>):T{
        return retrofit.create(serviceType)
    }
}