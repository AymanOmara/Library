package com.example.liberary.View.Activities


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.preference.Preference
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.liberary.App.MyContextWrapper
import com.example.liberary.Course
import com.example.liberary.R
import com.example.liberary.View.Fragment.FavoriteFragment
import com.example.liberary.View.Fragment.HomeFragment
import com.example.liberary.View.Fragment.RecentOpenFragment
import com.example.liberary.ViewModel.ViewModel
import com.example.liberary.constants.Constants
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*


class HomeActivity : AppCompatActivity() {
    private var courses: ArrayList<Course>? = null
    private val bundle = Bundle()
    private lateinit var toggle :ActionBarDrawerToggle
    private lateinit var viewModel:ViewModel
    private lateinit var action: View
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
         action = item!!.actionView



        runBlocking {  action!!.findViewById<SwitchCompat>(R.id.switchDarkModeState)!!.isChecked = viewModel.getPreferences().single().isDarkMode }
        action!!.findViewById<SwitchCompat>(R.id.switchDarkModeState)!!.setOnCheckedChangeListener { _, b ->
            if (b){
                Log.d("on click called","called")
                viewModel.saveDarkModeState(true)

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)

            }else if(!b){
                Log.d("on click called","called")
                viewModel.saveDarkModeState(false)

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                supportActionBar?.setDisplayHomeAsUpEnabled(true)


            }
        }
        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.changeLanguage -> {
                    lifecycleScope.launch {
                        viewModel.getPreferences().collect{
                            if(it.language == "ar") {
                                viewModel.saveToPreferences("en")
                            }
                            else{
                                viewModel.saveToPreferences("ar")
                            }
                        }
                    }
                    val myCutome = Intent(this@HomeActivity, HomeActivity::class.java)

                    myCutome.putExtras(intent)
                    Log.d("my item called","my item called")
                    startActivity(myCutome)

                }
                R.id.switchDarkModeState -> {

                }
                R.id.logout -> {

                    viewModel.clearAllData()
                    restartApp()
                }
            }
            true
        }

        bottomNavigation.show(0)
        bottomNavigation.add(MeowBottomNavigation.Model(0, R.drawable.homeicon))
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.favoriteicon))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.recenticon))

        courses = intent.getSerializableExtra(Constants.courses) as ArrayList<Course>?


        bottomNavigation.setOnClickMenuListener { meow ->
            when (meow.id){
                0 -> {
                    val homeFragment = HomeFragment()
                    courses = intent.getSerializableExtra(Constants.courses) as ArrayList<Course>?
                    bundle.putSerializable(Constants.homeCourses,courses)
                    homeFragment.arguments = bundle
                    replaceFragment(homeFragment)
                }
                1 -> {

                    val favoriteFragment = FavoriteFragment()
                    lifecycleScope.launch {
                        viewModel.getData().collect {
                            bundle.putSerializable(Constants.favorites,it)
                            favoriteFragment.arguments = bundle
                            replaceFragment(favoriteFragment)

                        }
                    }
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

    override fun attachBaseContext(newBase: Context?) {
        val sharedPreferences = newBase?.getSharedPreferences(Constants.sharedName,MODE_PRIVATE)
        val language = sharedPreferences?.getString(Constants.language, "en")
        super.attachBaseContext(newBase?.let { MyContextWrapper.wrap(it, language!!) })
        val locale = Locale(language!!)
        val resources = baseContext.resources
        val conf = resources.configuration
        conf.locale = locale
        resources.updateConfiguration(conf, resources.displayMetrics)
    }

    override fun onDestroy() {
        super.onDestroy()
        action = View(this)
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
    private fun restartApp(){
        finish()
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()
    }
}