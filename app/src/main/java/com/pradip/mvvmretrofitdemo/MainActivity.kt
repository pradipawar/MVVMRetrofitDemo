package com.pradip.mvvmretrofitdemo




import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pradip.mvvmretrofitdemo.adapter.UserAdapter
import com.pradip.mvvmretrofitdemo.model.UserList
import com.pradip.mvvmretrofitdemo.model.UserListItem
import com.pradip.mvvmretrofitdemo.viewmodel.UserViewModel
import com.pradip.mvvmretrofitdemo.viewmodelfactory.UserViewModelFactory

class MainActivity : AppCompatActivity(), UserAdapter.onClickListerner{
    private lateinit var listUser:MutableList<UserListItem>
    private lateinit var adpter : UserAdap
    private lateinit var recycler_main:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ///RecyclerView Addede here...
        recycler_main = findViewById(R.id.recycler_main)

        recycler_main.layoutManager = LinearLayoutManager(this@MainActivity)
        listUser= mutableListOf<UserListItem>()
        adpter = UserAdapter(this,listUser)
        recycler_main.adapter=adpter
        val userViewModel = ViewModelProviders.of(this,UserViewModelFactory(this)).get(UserViewModel::class.java)

        userViewModel.getData().observe(this,object :Observer<MutableList<UserListItem>>{
            override fun onChanged(t: MutableList<UserListItem>?) {
                listUser.clear()
                t?.let{
                    listUser.addAll(it)
                    adpter.notifyDataSetChanged()
                }
            }

        })

    }

    override fun onClick(id: String) {
        Log.v("MyId111","Iddd"+id)
    }
}