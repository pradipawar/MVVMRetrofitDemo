package com.pradip.mvvmretrofitdemo

import android.content.Context

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.pradip.mvvmretrofitdemo.client.ApiClent
import com.pradip.mvvmretrofitdemo.model.User
import com.pradip.mvvmretrofitdemo.utility.Utility.hideProgressBar
import com.pradip.mvvmretrofitdemo.utility.Utility.showProgressBar
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

object Repository {

    fun getMutableLiveData(context: Context): MutableLiveData<ArrayList<User>>{
        val mutableLiveData = MutableLiveData<ArrayList<User>>()

        context.showProgressBar()

        ApiClent.apiServices.getUser().enqueue(object  : Callback<MutableList<User>>{
            override fun onResponse(
                call: Call<MutableList<User>>,
                response: Response<MutableList<User>>
            ) {
               hideProgressBar()
                val userResponse = response.body()
                userResponse?.let {
                    mutableLiveData.value = it as ArrayList<User>
                }
            }

            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
               hideProgressBar()
                Log.i("error",t.localizedMessage)
            }

        })
        Log.i("MYMutableData",mutableLiveData.value.toString())
       return mutableLiveData
    }
}