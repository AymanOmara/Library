package com.example.liberary.View.Activities

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.liberary.Course
import com.example.liberary.R
import com.example.liberary.View.Fragment.FavoriteFragment
import com.example.liberary.View.Fragment.HomeFragment
import com.example.liberary.View.Fragment.RecentOpenFragment
import com.example.liberary.ViewModels.ViewModel
import com.example.liberary.constants.Constants
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class HomeActivity : AppCompatActivity() {
    var courses: ArrayList<Course>? = null
    val bundle = Bundle()
    lateinit var toggle :ActionBarDrawerToggle
    lateinit var viewModel:ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.initContext(this)
        val menu: Menu = navigationView.menu
        val drawerLayout:DrawerLayout = findViewById(R.id.navigationDrawer)
        val navigationView:NavigationView = findViewById(R.id.navigationView)
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val item =  menu.findItem(R.id.app_bar_switch)
        val action = item?.actionView

        action!!.findViewById<SwitchCompat>(R.id.switchDarkModeState)!!.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                Log.d("done","true")
            }else{
                Log.d("done","false")
            }
        }
        navigationView.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.changeLanguage -> {Toast.makeText(applicationContext,"change language ",Toast.LENGTH_LONG).show()}
                R.id.switchDarkModeState ->{

                }
            }


            true
        }

        bottomNavigation.show(0)
        bottomNavigation.add(MeowBottomNavigation.Model(0, R.drawable.homeicon))
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.favoriteicon))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.recenticon))

        courses = intent.getSerializableExtra(Constants.courses) as ArrayList<Course>?


        bottomNavigation.setOnClickMenuListener {
            when (it.id){
                0 -> {
                    val homeFragment = HomeFragment()
                    courses = intent.getSerializableExtra(Constants.courses) as ArrayList<Course>?
                    bundle.putSerializable(Constants.homeCourses,courses)
                    homeFragment.arguments = bundle
                    replaceFragment(homeFragment)
                }
                1 -> {
                    var newData = ArrayList<Course>()
                    val favoriteFragment = FavoriteFragment()
                    lifecycleScope.launch {
                        viewModel.getData().collect() {
                            newData.addAll(it)
                            Log.d("inside activity","${it.size}")
                            //courses?.addAll(it)
                        }
                        bundle.putSerializable(Constants.favorites,newData)
                        favoriteFragment.arguments = bundle
                        replaceFragment(favoriteFragment)
                    }


                    //courses = intent.getSerializableExtra(Constants.courses) as ArrayList<Course>?

                }
                2 ->{
                    replaceFragment(RecentOpenFragment())
                }
            }
        }
        val homeFragment = HomeFragment()
        bundle.putSerializable(Constants.homeCourses,courses)
        homeFragment.arguments = bundle
        replaceFragment(homeFragment)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return  true
        }
        return super.onOptionsItemSelected(item)

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransAction = fragmentManager.beginTransaction()
        fragmentTransAction.replace(R.id.framelayout, fragment)
        fragmentTransAction.commit()
    }

}