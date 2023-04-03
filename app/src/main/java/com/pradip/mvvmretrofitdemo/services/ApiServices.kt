package com.pradip.mvvmretrofitdemo.services

import com.pradip.mvvmretrofitdemo.model.GetDataById
import com.pradip.mvvmretrofitdemo.model.UserList
import com.pradip.mvvmretrofitdemo.model.UserListItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {

    @GET("rockets")
    fun getUser(): Call<MutableList<UserListItem>>

    @GET("rockets/{id}")
    fun getDetails(@Path("id")  id: String):Call<GetDataById>
}