package com.example.liberary.View.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.liberary.Course
import com.example.liberary.Major
import com.example.liberary.R
import com.example.liberary.constants.Constants

class WelcomeActivity : AppCompatActivity() {
    private var businessEnglishBtn : Button? = null
    private var businessArabicBtn : Button? = null
    private var myIntent : Intent? = null
    private var majors:ArrayList<Major>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        myIntent = Intent(this, MajorsActivity::class.java)
        majors = ArrayList()
        supportActionBar?.hide()
        findView()
        setUpOnClickAction()

    }
    fun findView(){
        businessEnglishBtn = findViewById(R.id.businessEnglishbtn)
        businessArabicBtn = findViewById(R.id.businessArabicbtn)
    }
    fun setUpOnClickAction() {
        businessEnglishBtn?.setOnClickListener {
            var courseArrayList:ArrayList<Course> =  arrayListOf(Course("machine learning", "info 401", "hello from description", "4", "my refrence","pre"), Course("stat401","stat401","hello from my descroption","my refrence ","l"," 401"))
            majors = arrayListOf(Major("Information systems", courseArrayList))
            myIntent?.putExtra(Constants.major,majors)



            startActivity(myIntent)
        }
        businessArabicBtn?.setOnClickListener {

            startActivity(myIntent)
        }

    }
}