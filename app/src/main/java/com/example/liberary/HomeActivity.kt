package com.example.liberary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigation.show(0)
        bottomNavigation.add(MeowBottomNavigation.Model(0, R.drawable.homeicon))
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.favoriteicon))

        bottomNavigation.setOnClickMenuListener {
            when (it.id){
                0 -> {
                    replaceFragment(HomeFragment())
                }
                1-> {
                    replaceFragment(FavoriteFragment())
                }
            }

        }
        replaceFragment(HomeFragment())


    }
    private fun replaceFragment(fragment: Fragment){
    val fragmentManager = supportFragmentManager
        val fragmentTransAction = fragmentManager.beginTransaction()
        fragmentTransAction.replace(R.id.framelayout, fragment)
        fragmentTransAction.commit()
    }
}