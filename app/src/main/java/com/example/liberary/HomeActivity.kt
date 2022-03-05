package com.example.liberary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var buttomNavigationView: BottomNavigationView? = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        buttomNavigationView = findViewById(R.id.bottomNavigationBar)
        replaceFragment(HomeFragment())
        buttomNavigationView?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homebtnbar -> {
                    replaceFragment(HomeFragment())
                    // Write your code here
                }
                R.id.favoritenavbtn-> {
                    replaceFragment(FavoriteFragment())
                    // Write your code here
                }
            }

            return@setOnItemSelectedListener true
        }



    }
    private fun replaceFragment(fragment: Fragment){
    val fragmentManager = supportFragmentManager
        val fragmentTransAction = fragmentManager.beginTransaction()
        fragmentTransAction.replace(R.id.frameLayout,fragment)
        fragmentTransAction.commit()
    }
}