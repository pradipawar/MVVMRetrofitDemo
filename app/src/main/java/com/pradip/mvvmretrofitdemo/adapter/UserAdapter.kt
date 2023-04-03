package com.pradip.mvvmretrofitdemo.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pradip.mvvmretrofitdemo.DetailsActivity
import com.pradip.mvvmretrofitdemo.R
import com.pradip.mvvmretrofitdemo.model.UserListItem

class UserAdapter(private val context: Context,val list: MutableList<UserListItem>) : RecyclerView.Adapter<UserAdapter.MyViewHolder> (){
    private var onClickListener: onClickListerner? = null
  //  private lateinit var list: MutableList<UserListItem>
    class MyViewHolder (var view: View) : RecyclerView.ViewHolder(view){

        var name: TextView? = null
        var info1: TextView? = null
        var info2: TextView? = null
        var imageView: ImageView? = null

        init {
            name = view.findViewById(R.id.txt_user_name)
            info1 = view.findViewById(R.id.txt_user_info1)
            info2 = view.findViewById(R.id.txt_user_info2)
            imageView = view.findViewById(R.id.imageview)
        }
    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         val inflater = LayoutInflater.from(context)
         val view: View = inflater.inflate(R.layout.user_row,parent,false)
         return MyViewHolder(view)
     }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = list.get(position)

         holder.name?.text = user?.name
         holder.info1?.text = user?.country
         holder.info2?.text = user?.engines?.number.toString()
         holder.imageView?.let {
             Glide.with(holder.itemView.context)
                 .load(user.flickr_images.get(0))
                 .into(it)
         };
         holder.itemView.setOnClickListener {
             val intent = Intent(context,DetailsActivity::class.java)
             intent.putExtra("Id",user.id.toString())
             context.startActivity(intent)

          // onClickListener?.onClick(user.id.toString())
         }
     }



     override fun getItemCount(): Int {
       return list.size
     }
interface onClickListerner{
    fun onClick( id: String)
}

 }