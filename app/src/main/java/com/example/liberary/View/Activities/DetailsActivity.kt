package com.example.liberary.View.Activities


import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.liberary.Course
import com.example.liberary.LocalModel.LocalModel
import com.example.liberary.R
import com.example.liberary.ViewModel.ViewModel
import com.example.liberary.constants.Constants
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.File


class DetailsActivity : AppCompatActivity() {
    private  var viewModel = ViewModel()
    private lateinit var course:Course
    private lateinit var courseName:TextView
    private lateinit var courseID:TextView
    private lateinit var coursePrerequest:TextView
    private lateinit var courseIntroduction:TextView
    private lateinit var favorite:Button
    private lateinit var recentCourse:Course
    private lateinit var refrences:TextView
    private lateinit var manager:DownloadManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        findViewByid()
        course = intent.getSerializableExtra(Constants.details) as Course
        manager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
        refrences.setOnClickListener {

            val uri =
                Uri.parse("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf")
            DownloadChecker()
            /*val request = DownloadManager.Request(uri)
                .setDestinationInExternalPublicDir(
                    Environment.DIRECTORY_DOCUMENTS,"fileName.pdf")
                .setAllowedOverRoaming(true)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
*/

           // val reference: Long = manager.enqueue(request)

           // Log.d("my url","${reference}")
           // Toast.makeText(this,"start loading ${reference}",Toast.LENGTH_LONG).show()

        }
        bindDataToView()
        LocalModel.context = this

        recentCourse = course.clone()

        recentCourse.isRecent = true
        lifecycleScope.launch {
            viewModel.addToFavorite(recentCourse).collect{
            }
        }
        favorite.setOnClickListener {
                addCourse(course)
        }
    }
    private fun findViewByid(){
        courseName = findViewById(R.id.courseDetailsNameValue)
        courseID = findViewById(R.id.courseDetailsIDValue)
        coursePrerequest = findViewById(R.id.prerequest)
        courseIntroduction = findViewById(R.id.introductionValue)
        favorite = findViewById(R.id.addToFavorite)
        refrences = findViewById(R.id.refrences)
    }
    private fun bindDataToView(){
        courseName.text = course.courseName
        courseID.text = course.courseCode
        courseIntroduction.text = course.courseDescription
        coursePrerequest.text = course.preRequest
        refrences.text = course.refreces
    }
    fun DownloadChecker() {
        val applictionFile = File(
            Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOCUMENTS
            ).toString() + "/" + "${course.courseName+courseID}.pdf"
        )
        if(applictionFile.isFile()) {
            Toast.makeText(getApplicationContext(), "File Already Exists",
                Toast.LENGTH_LONG).show();
        }
         else {
            val servicestring: String = Context.DOWNLOAD_SERVICE
            val downloadmanager: DownloadManager
            downloadmanager = getSystemService(servicestring) as DownloadManager
            val uri = Uri.parse(course.refreces)
            val request = DownloadManager.Request(uri)
            request.setDestinationInExternalFilesDir(
                this@DetailsActivity,
                Environment.DIRECTORY_DOWNLOADS, "${course.courseName+courseID}.pdf"
            )

            val reference = downloadmanager.enqueue(request)
        }

    }
    private fun addCourse(course:Course){
        lifecycleScope.launch {
        viewModel.addToFavorite(course).collect(){
            if (it){
                showAlert(resources.getString(R.string.Done),resources.getString(R.string.isnotBefore))
            }else{
                showAlert(resources.getString(R.string.Error),resources.getString(R.string.isBefore))
            }
        }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        viewModel.removeRecent()
    }
    private fun showAlert(header:String, body:String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(header)
        builder.setMessage(body)
        builder.show()
    }
}