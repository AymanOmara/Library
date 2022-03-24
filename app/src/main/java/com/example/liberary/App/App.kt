package com.example.liberary.App

import android.app.Application
import android.content.Intent
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.liberary.View.Activities.MainActivity
import com.example.liberary.View.Activities.WelcomeActivity
import java.util.*

class App : Application
    () {
    lateinit var locale: Locale
    private var currentLanguage = "en"

    override fun onCreate() {
        super.onCreate()
        setLocale("ar")
        Log.d("AppAppAppAppAppAppApp","App")
        var change = ""
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val language = sharedPreferences.getString("language", "bak")
        if (language=="English" ) {
            change = "en"
        }else {
            change =""
        }
    //WelcomeActivity
        //BaseActivity.dLocale = Locale(change) //set any locale you want here
    }
     fun setLocale(localeName: String) {
        if (localeName != currentLanguage) {
            locale = Locale(localeName)
            val res = resources
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = locale
            res.updateConfiguration(conf, dm)
            val refresh = Intent(
                this,
                MainActivity::class.java
            )
            //startActivity(refresh)

        } else {
            Toast.makeText(
                this, "Language, , already, , selected)!", Toast.LENGTH_SHORT).show();
        }
    }
}

