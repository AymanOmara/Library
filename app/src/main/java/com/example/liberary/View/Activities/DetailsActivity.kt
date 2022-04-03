package com.example.liberary.View.Activities


import android.app.DownloadManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.webkit.URLUtil
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.liberary.Course
import com.example.liberary.LocalModel.LocalModel
import com.example.liberary.R
import com.example.liberary.ViewModel.ViewModel
import com.example.liberary.constants.Constants
import kotlinx.coroutines.launch


class DetailsActivity : AppCompatActivity() {
    private var viewModel = ViewModel()
    private lateinit var course: Course
    private lateinit var courseName: TextView
    private lateinit var courseID: TextView
    private lateinit var coursePrerequest: TextView
    private lateinit var courseIntroduction: TextView
    private lateinit var favorite: Button
    private lateinit var recentCourse: Course
    private lateinit var refrences: TextView
    private lateinit var manager: DownloadManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        findViewByid()
        course = intent.getSerializableExtra(Constants.details) as Course
        manager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
        refrences.setOnClickListener {
            val refrence = refrences.text.toString()
            if (URLUtil.isValidUrl(refrence)) {
                val request = DownloadManager.Request(Uri.parse(refrence))
                    .setDestinationInExternalPublicDir(
                        Environment.DIRECTORY_DOCUMENTS, "${course.courseName+" "+course.courseCode}.pdf"
                    )
                    .setAllowedOverRoaming(true)
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                    manager.enqueue(request)
            } else {
                showAlert(
                    resources.getString(R.string.Error),
                    resources.getString(R.string.notValidURL)
                )
            }
        }
        bindDataToView()
        LocalModel.context = this

        recentCourse = course.clone()

        recentCourse.isRecent = true
        lifecycleScope.launch {
            viewModel.addToFavorite(recentCourse).collect {
            }
        }
        favorite.setOnClickListener {
            addCourse(course)
        }
    }

    private fun findViewByid() {
        courseName = findViewById(R.id.courseDetailsNameValue)
        courseID = findViewById(R.id.courseDetailsIDValue)
        coursePrerequest = findViewById(R.id.prerequest)
        courseIntroduction = findViewById(R.id.introductionValue)
        favorite = findViewById(R.id.addToFavorite)
        refrences = findViewById(R.id.refrences)
    }

    private fun bindDataToView() {
        courseName.text = course.courseName
        courseID.text = course.courseCode
        courseIntroduction.text = course.courseDescription
        coursePrerequest.text = course.preRequest
        refrences.text = course.refreces
    }

    private fun addCourse(course: Course) {
        lifecycleScope.launch {
            viewModel.addToFavorite(course).collect {
                if (it) {
                    showAlert(
                        resources.getString(R.string.Done),
                        resources.getString(R.string.isnotBefore)
                    )
                } else {
                    showAlert(
                        resources.getString(R.string.Error),
                        resources.getString(R.string.isBefore)
                    )
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        viewModel.removeRecent()
    }

    private fun showAlert(header: String, body: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(header)
        builder.setMessage(body)
        builder.show()
    }
}