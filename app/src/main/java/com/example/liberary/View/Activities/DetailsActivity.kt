package com.example.liberary.View.Activities


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.liberary.Course
import com.example.liberary.R
import com.example.liberary.constants.Constants


class DetailsActivity : AppCompatActivity() {
    lateinit var course:Course
    lateinit var courseName:TextView
    lateinit var courseID:TextView
    lateinit var coursePrerequest:TextView
    lateinit var courseIntroduction:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        findViewByid()
        course = intent.getSerializableExtra(Constants.details) as Course
        bindDataToView()

    }
    fun findViewByid(){
        courseName = findViewById(R.id.courseDetailsNameValue)
        courseID = findViewById(R.id.courseDetailsIDValue)
        coursePrerequest = findViewById(R.id.prerequest)
        courseIntroduction = findViewById(R.id.introductionValue)
    }
    fun bindDataToView(){
        courseName.text = course.courseName
        courseID.text = course.courseCode
        courseIntroduction.text = course.courseDescription
        coursePrerequest.text = course.preRequest

    }

}