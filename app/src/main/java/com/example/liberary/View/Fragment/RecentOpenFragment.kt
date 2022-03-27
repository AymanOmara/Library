package com.example.liberary.View.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.liberary.Adapters.CoursesAdapter
import com.example.liberary.Course
import com.example.liberary.R
import com.example.liberary.View.Activities.DetailsActivity
import com.example.liberary.ViewModel.ViewModel
import com.example.liberary.constants.Constants
import com.example.liberary.constants.Constants.Companion.courses
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking


class RecentOpenFragment : Fragment() {
    private  lateinit var adapter: CoursesAdapter
    private lateinit var viewModel: ViewModel
    private var courses = ArrayList<Course>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        runBlocking {
            viewModel.getOPendRecent().collect{
                courses = it
                adapter = CoursesAdapter(it){ getPressesdItemIndex(it)}
            }
        }
        val view = inflater.inflate(R.layout.fragment_recent_open, container, false)
        val recyclerView:RecyclerView = view.findViewById(R.id.recentrc)
        recyclerView.layoutManager =  LinearLayoutManager(this.context)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
        return view
    }
    private fun getPressesdItemIndex(index:Int){
        moveToNewActivity(courses?.get(index)!!)
    }
    private fun moveToNewActivity(withCourse: Course) {
        val i = Intent(activity, DetailsActivity::class.java)
        i.putExtra(Constants.details,withCourse)
        startActivity(i)
    }

    override fun onResume() {
        super.onResume()
        runBlocking {
            viewModel.getOPendRecent().collect{
                courses = it
                adapter = CoursesAdapter(it){ getPressesdItemIndex(it)}
            }
        }
        adapter.notifyDataSetChanged()
    }

}