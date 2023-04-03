package com.pradip.mvvmretrofitdemo.client

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.pradip.mvvmretrofitdemo.services.ApiServices
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClent {

    private const val BASE_URL = "https://api.spacexdata.com/v4/"
    var logging = HttpLoggingInterceptor()

    private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpClient : OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    private val retrofit : Retrofit by lazy {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(logging).build()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    val apiServices : ApiServices by lazy {
        retrofit.create(ApiServices::class.java)
    }
}