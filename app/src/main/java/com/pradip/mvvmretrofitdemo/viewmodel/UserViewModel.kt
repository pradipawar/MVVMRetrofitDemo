package com.pradip.mvvmretrofitdemo.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pradip.mvvmretrofitdemo.Repository
import com.pradip.mvvmretrofitdemo.model.User
import com.pradip.mvvmretrofitdemo.utility.Utility.isInternetAvaliable

class UserViewModel(private val context: Context) : ViewModel() {
    private var listData = MutableLiveData<ArrayList<User>>()

    init {
        var repositoryq = Repository


        if(context.isInternetAvaliable()){
            listData = repositoryq.getMutableLiveData(context)
        }
    }
    fun getData():MutableLiveData<ArrayList<User>>{
        return listData
    }
}


