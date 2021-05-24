package com.flora.floratripapp.network

import com.flora.floratripapp.data.ResponseData
import retrofit2.http.GET

interface ApiInterface {
    @GET("response.json")
    suspend fun getArticle():ResponseData?
}