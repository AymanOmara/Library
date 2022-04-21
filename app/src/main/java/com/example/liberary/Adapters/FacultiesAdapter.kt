package com.example.liberary.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.liberary.Faculty
import com.example.liberary.R

class FacultiesAdapter(private var itemList: ArrayList<Faculty>, private val onItemClicked: (position: Int) -> Unit): RecyclerView.Adapter<FacultiesAdapter.MyViewHolder>()  {
    class MyViewHolder(view: View, private val onItemClicked: (position: Int) -> Unit):RecyclerView.ViewHolder(view), View.OnClickListener{
        var courseCode: TextView = view.findViewById(R.id.majorName)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            onItemClicked(position)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultiesAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.majoritem, parent, false)
        return FacultiesAdapter.MyViewHolder(itemView, onItemClicked)
    }
    override fun onBindViewHolder(holder: FacultiesAdapter.MyViewHolder, position: Int) {
        val item = itemList[position]
        holder.courseCode.text = item.FacultyName

    }
    override fun getItemCount(): Int {
        return  itemList.size
    }
}