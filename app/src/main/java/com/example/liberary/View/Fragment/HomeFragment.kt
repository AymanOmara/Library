package com.example.liberary.View.Fragment

import android.content.Intent
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
import com.example.liberary.Course
import com.example.liberary.CoursesAdapter
import com.example.liberary.R
import com.example.liberary.View.Activities.DetailsActivity
import com.example.liberary.constants.Constants
import com.google.android.material.internal.ContextUtils
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
        courses = arguments?.get(Constants.homeCourses) as ArrayList<Course>
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        searchBar = view.findViewById(R.id.searchView)
        searchBar?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                filter(newText)
                return true
            }})
        val recyclerView:RecyclerView =  view.findViewById(R.id.recyclerviewCourses)
        adapter = CoursesAdapter(courses!!) {
            getPressesdItemIndex(it)
        }
        val layoutManager = LinearLayoutManager(this.context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
        return view
    }
    fun filter(text:String){
        var filterdCourses:ArrayList<Course> = ArrayList()
        for (i in courses!!) {
            if (i.courseCode.lowercase().contains(text.lowercase())) {
                filterdCourses?.add(i)
            }

        }
        adapter.filterCourses(filterdCourses)

    }
    fun getPressesdItemIndex(index:Int){
        Toast.makeText(activity?.applicationContext, courses?.get(index)?.courseCode,Toast.LENGTH_SHORT).show()
        courses?.get(index)?.let { moveToNewActivity(it) }
    }
    private fun moveToNewActivity(withCourse: Course) {
        val i = Intent(activity, DetailsActivity::class.java)
        i.putExtra(Constants.details,withCourse)
        startActivity(i)
    }



}