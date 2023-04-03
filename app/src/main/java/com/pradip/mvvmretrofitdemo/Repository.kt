package com.pradip.mvvmretrofitdemo

import android.content.Context

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.pradip.mvvmretrofitdemo.client.ApiClent
import com.pradip.mvvmretrofitdemo.model.GetDataById
import com.pradip.mvvmretrofitdemo.model.UserList
import com.pradip.mvvmretrofitdemo.model.UserListItem
import com.pradip.mvvmretrofitdemo.utility.Utility.hideProgressBar
import com.pradip.mvvmretrofitdemo.utility.Utility.showProgressBar
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

object Repository {

    fun getMutableLiveData(): MutableLiveData<MutableList<UserListItem>>{
        val mutableLiveData = MutableLiveData<MutableList<UserListItem>>()

       // context.showProgressBar()

        ApiClent.apiServices.getUser().enqueue(object  : Callback<MutableList<UserListItem>>{
            override fun onResponse(
                call: Call<MutableList<UserListItem>>,
                response: Response<MutableList<UserListItem>>
            ) {
               hideProgressBar()
                val userResponse = response.body()
                userResponse?.let {
                    mutableLiveData.value = it as MutableList<UserListItem>
                }
            }

            override fun onFailure(call: Call<MutableList<UserListItem>>, t: Throwable) {
               hideProgressBar()
                Log.i("error",t.localizedMessage)
            }

        })
        Log.i("MYMutableData",mutableLiveData.value.toString())
       return mutableLiveData
    }

    fun getMutableDetailsData( id:String): MutableLiveData<GetDataById>{
        val mutableLiveDetailsData = MutableLiveData<GetDataById>()

      //  context.showProgressBar()

        ApiClent.apiServices.getDetails(id).enqueue(object  : Callback<GetDataById>{
            override fun onResponse(
                call: Call<GetDataById>,
                response: Response<GetDataById>
            ) {
                hideProgressBar()
                val userResponse = response.body()
                userResponse?.let {
                    mutableLiveDetailsData.value = it
                }
            }

            override fun onFailure(call: Call<GetDataById>, t: Throwable) {
                hideProgressBar()
                Log.i("error",t.localizedMessage)
            }

        })
        Log.i("MYMutableData",mutableLiveDetailsData.value.toString())
        return mutableLiveDetailsData
    }


}