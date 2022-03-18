package com.example.liberary

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : Fragment() {
    private lateinit var adapter: CoursesAdapter
    var searchBar:SearchView? = null
    var courses:ArrayList<Course>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        courses = arguments?.get("ayman") as ArrayList<Course>
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        searchBar = view.findViewById(R.id.searchView)
        searchBar?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                Log.d("search",newText)
                //Toast.makeText(this.context,newText,Toast.LENGTH_SHORT).show()
                //Toast.makeText(this@HomeFragment,newText,)
                filter(newText)
                return true
            }})
        val recyclerView:RecyclerView =  view.findViewById(R.id.recyclerviewCourses)
        adapter = CoursesAdapter(courses!!,{

        })
        val layoutManager = LinearLayoutManager(this.context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
        return view
    }
    fun filter(text:String){
        var filterdCourses:ArrayList<Course> = ArrayList()
        for (i in courses!!) {
            if (i.courseCode.toLowerCase(Locale.ROOT).contains(text.toLowerCase(Locale.ROOT))) {
                filterdCourses?.add(i)
            }

        }

        ///Log.d("search countrt","${filterdCourses.size}")
        adapter.filterCourses(filterdCourses)

    }

}