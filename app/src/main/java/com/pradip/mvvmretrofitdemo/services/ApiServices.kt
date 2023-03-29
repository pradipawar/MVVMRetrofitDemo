package com.pradip.mvvmretrofitdemo.services

import com.pradip.mvvmretrofitdemo.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    @GET("rockets")
    fun getUser(): Call<MutableList<User>>
}