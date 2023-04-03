package com.pradip.mvvmretrofitdemo.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pradip.mvvmretrofitdemo.Repository
import com.pradip.mvvmretrofitdemo.model.GetDataById
import com.pradip.mvvmretrofitdemo.model.UserListItem


class UserViewModel(private val id: Context) : ViewModel() {

    private var listData = MutableLiveData<MutableList<UserListItem>>()
    private var userDetailsData = MutableLiveData<GetDataById>()
// //   private var id:String=null!!
    var repositoryq=Repository
    init {
         repositoryq = Repository


      /*  if(withContext().isInternetAvaliable()){


        }*/
    }
    fun getData():MutableLiveData<MutableList<UserListItem>>{
        listData = repositoryq.getMutableLiveData()
        return listData
    }
    fun getDetailsData( id:String):MutableLiveData<GetDataById>{

        userDetailsData = repositoryq.getMutableDetailsData(id)
        return userDetailsData
    }
}


