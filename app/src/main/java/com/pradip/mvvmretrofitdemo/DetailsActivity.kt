package com.pradip.mvvmretrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.get
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.pradip.mvvmretrofitdemo.adapter.MainAdapter
import com.pradip.mvvmretrofitdemo.databinding.ActivityDetailsBinding
import com.pradip.mvvmretrofitdemo.model.GetDataById
import com.pradip.mvvmretrofitdemo.model.UserListItem
import com.pradip.mvvmretrofitdemo.viewmodel.UserViewModel
import com.pradip.mvvmretrofitdemo.viewmodelfactory.UserViewModelFactory

class DetailsActivity : AppCompatActivity() {
    private lateinit var listUser:MutableList<String>
    private lateinit var binding: ActivityDetailsBinding
     val mainAdapter=MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listUser= mutableListOf<String>()
        val intent=getIntent()
        var myValue=intent.getStringExtra("Id")
        Log.v("getValue"," "+myValue.toString())
        val userViewModel = ViewModelProviders.of(this, UserViewModelFactory(this)).get(
            UserViewModel::class.java)


userViewModel.getDetailsData(myValue!!).observe(this) {

    binding.name.text = it.name.toString()
    binding.mobileNumber.text= it.company
    //listUser.addAll(it)
    listUser.addAll(it.flickr_images)

    Log.v("listUser",""+listUser.size)
    var flikerimage:Int =  it.flickr_images.size
    Log.v("FlickerImage",""+flikerimage.toString())
    for( item in listUser){
        Log.v("listUser11",""+item)
        Glide.with(this)
            .load(item)
            .into(binding.image1);

    }
    binding.active.text= it.active.toString()
    binding.cost.text = it.cost_per_launch.toString()
    binding.rate.text = it.cost_per_launch.toString()
    binding.Description.text = it.description.toString()
    binding.wikipedia.text = it.wikipedia.toString()
    binding.height.text=it.height.toString()
}


    }
}
