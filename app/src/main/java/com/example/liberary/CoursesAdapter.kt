package com.example.liberary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CoursesAdapter(private var itemList: ArrayList<Course>, private val onItemClicked: (position: Int) -> Unit): RecyclerView.Adapter<CoursesAdapter.MyViewHolder>()  {
    class MyViewHolder(view: View, private val onItemClicked: (position: Int) -> Unit):RecyclerView.ViewHolder(view), View.OnClickListener{
        var courseCode: TextView = view.findViewById(R.id.courseCode)
        var courseName: TextView = view.findViewById(R.id.courseName)
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
                .inflate(R.layout.courserecyclerviewitem, parent, false)
        return CoursesAdapter.MyViewHolder(itemView, onItemClicked)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemList[position]
        holder.courseCode.text = item.courseCode
        holder.courseName.text = item.courseName
    }

    override fun getItemCount(): Int {
        return  itemList.size
    }

}