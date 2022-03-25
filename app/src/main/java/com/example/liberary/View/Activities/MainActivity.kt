package com.example.liberary.View.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.liberary.R
import com.example.liberary.ViewModel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*


class MainActivity : AppCompatActivity() {
    private var myIntent : Intent? = null
    private lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.initContext(this)
        myIntent = Intent(this, WelcomeActivity::class.java)
        lifecycleScope.launch{
            val prefs = viewModel.getPreferences().single()
            if (prefs.isDarkMode){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else if(!prefs.isDarkMode){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            if (prefs.language == "en"){
                setAppLocale(this@MainActivity,"en")
            }else if(prefs.language == "ar"){
                setAppLocale(this@MainActivity,"ar")
            }else{
                setAppLocale(this@MainActivity,"en")
            }

            delay(5000)
            withContext(Dispatchers.Main){
                startActivity(myIntent)
                finish()
            }
        }
    }
    fun setAppLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        context.createConfigurationContext(config)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }
}