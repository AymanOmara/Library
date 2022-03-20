package com.example.liberary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var courses:ArrayList<Course>? = null
        val bundle = Bundle()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigation.show(0)
        bottomNavigation.add(MeowBottomNavigation.Model(0, R.drawable.homeicon))
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.favoriteicon))


        courses = intent.getSerializableExtra("coursesBUNDLE") as ArrayList<Course>?


        bottomNavigation.setOnClickMenuListener {
            when (it.id){
                0 -> {
                    val homeFragment = HomeFragment()
                    courses = intent.getSerializableExtra("coursesBUNDLE") as ArrayList<Course>?
                    bundle.putSerializable("ayman",courses)
                    homeFragment.arguments = bundle
                    replaceFragment(homeFragment)
                }
                1 -> {
                    replaceFragment(FavoriteFragment())
                }
            }
        }
        val homeFragment = HomeFragment()
        bundle.putSerializable("ayman",courses)
        homeFragment.arguments = bundle
        replaceFragment(homeFragment)


    }
    private fun replaceFragment(fragment: Fragment){
    val fragmentManager = supportFragmentManager
        val fragmentTransAction = fragmentManager.beginTransaction()
        fragmentTransAction.replace(R.id.framelayout, fragment)
        fragmentTransAction.commit()
    }
}