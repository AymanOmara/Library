package com.example.liberary

import  android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

class MajorAdapter(private var itemList:ArrayList<String>): RecyclerView.Adapter<MajorAdapter.MyViewHolder>() {

    class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
        var itemTextView: TextView = view.findViewById(R.id.majorName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.majoritem, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val item = itemList[position]
        holder.itemTextView.text = item

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}