package com.pradip.mvvmretrofitdemo




import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pradip.mvvmretrofitdemo.adapter.UserAdapter
import com.pradip.mvvmretrofitdemo.model.User
import com.pradip.mvvmretrofitdemo.viewmodel.UserViewModel
import com.pradip.mvvmretrofitdemo.viewmodelfactory.UserViewModelFactory

class MainActivity : AppCompatActivity(){
    private lateinit var listUser:MutableList<User>
    private lateinit var adpter : UserAdapter
    private lateinit var recycler_main:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_main = findViewById(R.id.recycler_main)

        recycler_main.layoutManager = LinearLayoutManager(this@MainActivity)
        listUser= mutableListOf<User>()
        adpter = UserAdapter(this,listUser)
        recycler_main.adapter=adpter
        val userViewModel = ViewModelProviders.of(this,UserViewModelFactory(this)).get(UserViewModel::class.java)

        userViewModel.getData().observe(this,object :Observer<ArrayList<User>>{
            override fun onChanged(t: ArrayList<User>?) {
                listUser.clear()
                t?.let{
                    listUser.addAll(it)
                    adpter.notifyDataSetChanged()
                }
            }

        })

    }
}