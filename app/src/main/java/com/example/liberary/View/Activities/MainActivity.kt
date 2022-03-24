package com.example.liberary.View.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.liberary.LocalModel.LocalModel
import com.example.liberary.R


class MainActivity : AppCompatActivity() {
    private var myIntent : Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        myIntent = Intent(this, WelcomeActivity::class.java)
        Handler().postDelayed({
            startActivity(myIntent)
            finish()
        },5000)






    }

}