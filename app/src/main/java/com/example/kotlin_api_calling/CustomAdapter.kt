package com.example.kotlin_api_calling

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin_api_calling.ResponseModels.UserModel

internal class CustomAdapter(private var itemsList: ArrayList<UserModel>) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var id: TextView = view.findViewById(R.id.id)
        var fname: TextView = view.findViewById(R.id.fname)
        var lname: TextView = view.findViewById(R.id.lname)
        var email: TextView = view.findViewById(R.id.email)
        var img: ImageView = view.findViewById(R.id.img)

    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.id.text = item.id.toString()
        holder.fname.text = item.first_name.toString()
        holder.lname.text = item.last_name.toString()
        holder.email.text = item.email.toString()
        Glide.with(holder.itemView.getContext()).load(item.avatar).into(holder.img);


    }
    override fun getItemCount(): Int {
        return itemsList.size
    }
}