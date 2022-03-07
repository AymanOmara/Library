package com.example.liberary

import  android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

class MajorAdapter(private var itemList:ArrayList<String>,private val onItemClicked: (position: Int) -> Unit): RecyclerView.Adapter<MajorAdapter.MyViewHolder>() {

    class MyViewHolder(view: View, private val onItemClicked: (position: Int) -> Unit):RecyclerView.ViewHolder(view),View.OnClickListener{
        var itemTextView: TextView = view.findViewById(R.id.majorName)
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            onItemClicked(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.majoritem, parent, false)
        return MyViewHolder(itemView,onItemClicked)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val item = itemList[position]
        holder.itemTextView.text = item

    }


    override fun getItemCount(): Int {
        return itemList.size
    }
}