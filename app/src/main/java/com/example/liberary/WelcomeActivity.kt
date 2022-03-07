package com.example.liberary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {
    private var businessEnglishBtn : Button? = null
    private var businessArabicBtn : Button? = null
    private var myIntent : Intent? = null
    private var majors:ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        myIntent = Intent(this,MajorsActivity::class.java)
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

            majors = arrayListOf("Hamada","Hamada","Hamada","Hamada")
            myIntent?.putStringArrayListExtra("majors",majors)
            startActivity(myIntent)
        }
        businessArabicBtn?.setOnClickListener {
            majors = arrayListOf("حمادة بالجنزبيل","حمادة بالجنزبيل","حمادة بالجنزبيل","حمادة بالجنزبيل")
            myIntent?.putStringArrayListExtra("majors",majors)
            startActivity(myIntent)
        }

    }
}