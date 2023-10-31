package com.example.shoppingapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val productList: List<Product>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // LM fails to create view for some data then this method is used
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView= LayoutInflater.from(context).inflate(R.layout.each_item, parent, false)
        return MyViewHolder(itemView)
    }

    // populate data in the view
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem= productList[position]

        holder.title.text= currentItem.title

        // show image as well
        // to put image links into Image view , picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image);
    }

    // return the size of the list
    override fun getItemCount(): Int {
       return productList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var image: ShapeableImageView
        var title: TextView

        init {
            image= itemView.findViewById(R.id.productImage)
            title= itemView.findViewById(R.id.productName)
        }
    }

}