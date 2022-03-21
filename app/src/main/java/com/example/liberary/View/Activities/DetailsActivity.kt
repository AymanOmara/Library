package com.example.liberary.View.Activities


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.liberary.Course
import com.example.liberary.LocalModel.LocalModel
import com.example.liberary.R
import com.example.liberary.constants.Constants


class DetailsActivity : AppCompatActivity() {
    private lateinit var course:Course
    private lateinit var courseName:TextView
    private lateinit var courseID:TextView
    private lateinit var coursePrerequest:TextView
    private lateinit var courseIntroduction:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        findViewByid()
        course = intent.getSerializableExtra(Constants.details) as Course
        bindDataToView()
        LocalModel.context = this
        LocalModel.write(course)
        LocalModel.getAll()

    }
    private fun findViewByid(){
        courseName = findViewById(R.id.courseDetailsNameValue)
        courseID = findViewById(R.id.courseDetailsIDValue)
        coursePrerequest = findViewById(R.id.prerequest)
        courseIntroduction = findViewById(R.id.introductionValue)
    }
    private fun bindDataToView(){
        courseName.text = course.courseName
        courseID.text = course.courseCode
        courseIntroduction.text = course.courseDescription
        coursePrerequest.text = course.preRequest

    }

}