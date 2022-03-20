package com.example.liberary.View.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.liberary.Course
import com.example.liberary.LocalModel
import com.example.liberary.R


class MainActivity : AppCompatActivity() {
    private var myIntent : Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
       // val localModel =  LocalModel
//        LocalModel.write(Course("ayman","hello","hello","100","no","no"))
        //LocalModel.getAll()
        val localModel = LocalModel()
        localModel
        myIntent = Intent(this, WelcomeActivity::class.java)
        Handler().postDelayed({
            startActivity(myIntent)
            finish()
        },5000)






    }

}