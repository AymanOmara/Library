package com.example.liberary.View.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.liberary.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    private var myIntent : Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        myIntent = Intent(this, WelcomeActivity::class.java)
        lifecycleScope.launch (Dispatchers.Default){
            delay(5000)
            withContext(Dispatchers.Main){
                startActivity(myIntent)
                finish()
            }
        }
    }
}