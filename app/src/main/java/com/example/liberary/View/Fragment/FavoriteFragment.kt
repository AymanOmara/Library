package com.example.liberary.View.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.liberary.Adapters.CoursesAdapter
import com.example.liberary.Course
import com.example.liberary.ViewModels.FavoriteViewModel
import com.example.liberary.R
import com.example.liberary.View.Activities.DetailsActivity
import com.example.liberary.constants.Constants
import kotlinx.coroutines.flow.onEach


class FavoriteFragment : Fragment() {
    var viewModel = FavoriteViewModel()
    private lateinit var adapter: CoursesAdapter
    private var courses:ArrayList<Course>? = ArrayList()

    override  fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_favorite, container, false)
        courses = arguments?.get(Constants.favorites) as ArrayList<Course>

        val recyclerView: RecyclerView =  view.findViewById(R.id.favoritesrv)
        viewModel.getData().onEach { list ->
            courses = list
            adapter.notifyDataSetChanged()

        }
        adapter = CoursesAdapter(courses!!) {
            getPressesdItemIndex(it)
        }
        val layoutManager = LinearLayoutManager(this.context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        return  view
    }
    private fun getPressesdItemIndex(index:Int){
        moveToNewActivity(courses?.get(index)!!)
    }
    private fun moveToNewActivity(withCourse: Course) {
        val i = Intent(activity, DetailsActivity::class.java)
        i.putExtra(Constants.details,withCourse)
        startActivity(i)
    }

}