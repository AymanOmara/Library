package com.example.liberary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MajorsActivity : AppCompatActivity() {
    private var incomingIntent: Intent? = null
    var majorsArray:ArrayList<Major>? = null
    private lateinit var adapter: MajorAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_majors)
        incomingIntent = intent
        val args = incomingIntent?.getBundleExtra("BUNDLE")
        majorsArray = args?.get("ARRAYLIST") as ArrayList<Major>?

        val recyclerView :RecyclerView = findViewById(R.id.majorRecyclerView)
        adapter = MajorAdapter(majorsArray!!) { position -> onListItemClick(position) }


        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }
    private fun onListItemClick(position: Int) {

        val myIntent = Intent(this,HomeActivity::class.java)

        myIntent?.putExtra("coursesBUNDLE", majorsArray?.get(0)?.courses)
        startActivity(myIntent)
    }
}