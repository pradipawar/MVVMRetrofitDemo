package com.pradip.mvvmretrofitdemo.client

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.pradip.mvvmretrofitdemo.services.ApiServices
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClent {

    private const val BASE_URL = "https://api.spacexdata.com/v4/"

    private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpClient : OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    val apiServices : ApiServices by lazy {
        retrofit.create(ApiServices::class.java)
    }
}