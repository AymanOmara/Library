package com.example.liberary.View.Fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.liberary.Adapters.CoursesAdapter
import com.example.liberary.Course
import com.example.liberary.R
import com.example.liberary.View.Activities.DetailsActivity
import com.example.liberary.constants.Constants

class FavoriteFragment : Fragment() {

    private lateinit var adapter: CoursesAdapter
    private lateinit var animationView:LottieAnimationView
    private var courses:ArrayList<Course>? = ArrayList()

    override  fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view =  inflater.inflate(R.layout.fragment_favorite, container, false)
        val recyclerView: RecyclerView =  view.findViewById(R.id.favoritesrv)

        recyclerView.layoutManager = LinearLayoutManager(this.context)
        courses = arguments?.get(Constants.favorites) as ArrayList<Course>
        animationView = view.findViewById(R.id.favortieanimationView)
        adapter = CoursesAdapter(courses!!) { getPressesdItemIndex(it)}

        recyclerView.adapter = adapter

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

    override fun onResume() {
        super.onResume()
        courses = arguments?.get(Constants.favorites) as ArrayList<Course>
        if(courses?.size == 0){
            animationView.alpha = 1f
            animationView.isEnabled = true
            animationView.playAnimation()
        }else{
            animationView.alpha = 0f
            animationView.isEnabled = false
        }

        adapter = CoursesAdapter(courses!!) { getPressesdItemIndex(it)}
        adapter.notifyDataSetChanged()
    }

}