package com.example.liberary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MajorsActivity : AppCompatActivity() {
    var incomingIntent: Intent? = null
    var majorsArray:ArrayList<String>? = null
    private lateinit var adapter: MajorAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_majors)
        incomingIntent = intent
        majorsArray =  incomingIntent?.getStringArrayListExtra("majors")
        Toast.makeText(this,"${majorsArray?.size} hi",Toast.LENGTH_LONG).show()
        val recyclerView :RecyclerView = findViewById(R.id.majorRecyclerView)
        adapter = MajorAdapter(majorsArray!!)

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }
}