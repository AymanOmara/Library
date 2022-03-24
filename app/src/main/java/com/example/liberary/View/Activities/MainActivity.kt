package com.example.liberary.View.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.lifecycleScope
import com.example.liberary.LocalModel.LocalModel
import com.example.liberary.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private var myIntent : Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        myIntent = Intent(this, WelcomeActivity::class.java)
        lifecycleScope.launch {
            delay(5000)
            startActivity(myIntent)
            finish()
        }
    }
}