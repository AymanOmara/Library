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
    private lateinit var businessEnglishBtn : Button
    private lateinit var businessArabicBtn : Button
    private lateinit var myIntent : Intent
    private lateinit var majors:ArrayList<Major>

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
        businessEnglishBtn.setOnClickListener {
            val infromationSystemCourses:ArrayList<Course> =  arrayListOf(Course("Principles of Mathematics ", "MATH 101", "hello from description", "1", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","pre"),
                Course("Financial Mathematics","MATH 201","hello from my descroption","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"," 401"),
                Course("Descriptive Statistics","STS 201","hello from dec","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","401 , 406 ,407"),
                Course("Applied Statistics","STS 301","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"," 401"),
                Course("Advanced Statistics","STS 401","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"," 401"),
                Course("EMPTY FOR NOW","MATH 401","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"," 401"),
                Course("Introduction of Computer","COMP 102","hello from my descroption","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","COMP 101"),
                Course("Principles of Information Systems","INF 201","hello from my descroption","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","COMP 102"),
                Course("Principles of Programs Planning","INF 301","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"," INF 201"),
                Course("Basic of Systems Analysis","INF 302","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201"),
                Course("Data Base","INF 303","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201"),
                Course("System Design","INF 304","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 302"),
                Course("Experts Systems and Decision Support System","INF 306","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 303") ,
                Course("Machine Learning","INF 401","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"," 401"),
                Course("Data Communication Networks","INF 403","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"," 401"),
                Course("Systems Analysis & Design","INF 404","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"," 401"),
                Course("DataBases System Problems","INF 405","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"," 401"),
                Course("Medical Information Systems","INF 406","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"," 401"),
                Course("Advanced Information System","INF 407","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"," 401"),
            )
            val accountingCourses:ArrayList<Course> = arrayListOf(Course("accounting 404","account","hello","4","hjfgs","5256"))
            val financeCourses:ArrayList<Course> = arrayListOf(Course("finance 404","404","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","fin405"))
            majors = arrayListOf(Major("Information systems", infromationSystemCourses),
                Major("accounting",accountingCourses), Major("finance",financeCourses)
            )
            myIntent.putExtra(Constants.major,majors)



            startActivity(myIntent)
        }
        businessArabicBtn.setOnClickListener {

            //startActivity(myIntent)
        }

    }
}