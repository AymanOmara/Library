package com.example.liberary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

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
            var courseArrayList:ArrayList<Course> =  arrayListOf(Course("machine learning", "info 401", "hello from description", "4", "my refrence"))
            majors = arrayListOf(Major("Information systems", courseArrayList))
            val args = Bundle()
            args.putSerializable("ARRAYLIST", majors)
            myIntent?.putExtra("BUNDLE",args)
            /*
                    myArgs.putSerializable("courses", majorsArray?.get(position)?.courses)
        Toast.makeText(this,"${majorsArray?.get(0)?.courses?.get(0)?.courseCode} on click action",Toast.LENGTH_LONG).show()
        myIntent?.putExtra("coursesBUNDLE", myArgs)
             */
            startActivity(myIntent)
        }
        businessArabicBtn?.setOnClickListener {
            //majors = arrayListOf("حمادة بالجنزبيل","حمادة بالجنزبيل","حمادة بالجنزبيل","حمادة بالجنزبيل")
            //myIntent?.putStringArrayListExtra("majors",majors)
            startActivity(myIntent)
        }

    }
}