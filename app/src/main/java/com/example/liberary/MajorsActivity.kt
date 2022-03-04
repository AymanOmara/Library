package com.example.liberary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MajorsActivity : AppCompatActivity() {
    var incomingIntent: Intent? = null
    var majorsArray:ArrayList<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_majors)
        incomingIntent = intent
        majorsArray =  incomingIntent?.getStringArrayListExtra("majors")
        Toast.makeText(this,"${majorsArray?.size} hi",Toast.LENGTH_LONG).show()
    }
}