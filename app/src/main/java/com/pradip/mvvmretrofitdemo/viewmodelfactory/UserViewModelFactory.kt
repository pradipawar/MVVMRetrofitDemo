package com.pradip.mvvmretrofitdemo.viewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pradip.mvvmretrofitdemo.viewmodel.UserViewModel

class UserViewModelFactory(private val context: Context): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(context) as T
    }

}