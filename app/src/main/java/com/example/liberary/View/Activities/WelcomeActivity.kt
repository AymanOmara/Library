package com.example.liberary.View.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.liberary.*
import com.example.liberary.Adapters.FacultiesAdapter
import com.example.liberary.constants.Constants

class WelcomeActivity : AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter:FacultiesAdapter
    private lateinit var myIntent : Intent
    private lateinit var majors:ArrayList<Major>
    private lateinit var faculties:ArrayList<Faculty>

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
        recyclerView = findViewById(R.id.faculties_rv)
         faculties = arrayListOf(Faculty("Business English",R.drawable.business ,arrayListOf(
             Major("Information systems", arrayListOf(Course("Principles of Mathematics ", "MATH 101", "hello from description", "1", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","pre"),
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
                 Course("Advanced Information System","INF 407","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"," 401")))
         , Major("Finance",arrayListOf(Course("Financial Markets Theory","FIN 301","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Securities Intermediates","FIN 302","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201,ACC 202"),
                 Course("Portfolio Management","FIN 303","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201,ACC 202,MATH 201"),
                 Course("Monetary & Banking Policies","FIN 304","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201,ACC 202,MATH 201"),
                 Course("International Monetary Funds","FIN 305","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Egyptian Stock Exchange","FIN 306","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202,MATH 201,ECO 202"),
                 Course("Investments Banks","FIN 401","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 304"),
                 Course("Specialized Banks","FIN 402","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 304"),
                 Course("credit Management","FIN 403","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 304,ECO 302"),
                 Course("International Finance","FIN 404","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 305"),
                 Course("Operation Research im Finance & Investments","FIN 405","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","STS 201,BUS 304"),
                 Course("Quantitative Methods in Stock Exchange","FIN 406","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 302,FIN 303,FIN 306,STS 201"),
                 Course("The Central Banks","FIN 407","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 304,ECO 302"),
                 Course("Finance and Investments Problems","FIN 408","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 304,ECO 302"),
                 Course("Quantitative Methods in Banks & Portfolio","FIN 409","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 303,FIN 304,STS 201"),
                 Course("Financial Policies for Institutions","FIN 413","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 304")
             ))
         , Major("Accounting",arrayListOf(Course("Principles of Accounting","ACC 101","hello","1","hjfgs","NONE"),
                 Course("Financial Accounting","ACC 102","hello from my descroption","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 101"),
                 Course("Partnership Accounting","ACC 201","hello from dec","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102"),
                 Course("Corporations Accounting","ACC 202","hello from my descroption","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102"),
                 Course("Cost Accounting","ACC 301","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102,BUS 103"),
                 Course("Specialized Accounting","ACC 302","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102"),
                 Course("National and Governmental Accounting","ACC 303","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102"),
                 Course("Auditing","ACC 304","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                 Course("Tax Accounting (1)","ACC 305","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                 Course("Tax Accounting (2)","ACC 401","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                 Course("Cost Accounting Systems","ACC 402","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 301"),
                 Course("Operation Research in Accounting","ACC 403","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 301"),
                 Course("Financial Institutions Accounting","ACC 404","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202") ,
                 Course("Accounting Information Systems","ACC 405","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                 Course("Advanced Studies in Auditing","ACC 406","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 304"),
                 Course("Advanced Studies in Cost Accounting","ACC 407","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 402"),
                 Course("Managerial Accounting","ACC 408","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 301,BUS 304"),
                 Course("International Accounting","Acc 409","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                 Course("Accounting Problems","ACC 410","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 301,ACC 304")))
         ,Major("Business", arrayListOf(Course("Principles of Management","BUS 101","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","NONE"),
                 Course("Principles of Management","BUS 102","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Production Management","BUS 103","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Marketing","BUS 201","jdhdj","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Principles of Management","BUS 101","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Principles of Management","BUS 101","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Management Development","BUS 302","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Hospital Management","BUS 303","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Financial Management & Investment","BUS 304","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Specialized Institutions Management","BUS 305","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Small Business Administration","BUS 306","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Human Resource Management","BUS 307","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Managerial Problem","BUS 401","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Public Relations","BUS 402","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Financial Institution Management","BUS 403","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Business Strategies","BUS 404","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Management Information Systems","BUS 405","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Marketing Research & Advertising","BUS 406","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Communication","BUS 407","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Operations Research in Management","BUS 408","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Multinational Corporation Management","BUS 409","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201")))
         ,
             Major("Management",arrayListOf(Course("Principles of Management","BUS 101","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","NONE")))
         )
         ), Faculty(" Medicine",R.drawable.medicine, arrayListOf(
             Major("",
                 arrayListOf())
         )), Faculty("Dentistry",R.drawable.dentisry, arrayListOf(
             Major("",
                 arrayListOf())
         )), Faculty("Pharmacy",R.drawable.pharmacy, arrayListOf(
             Major("",
                 arrayListOf())
         )),Faculty("Physical Therapy",R.drawable.physicaltherapy, arrayListOf(
             Major("",
                 arrayListOf())
         )),Faculty("Biotechnology",R.drawable.biotechnology, arrayListOf(
             Major("",
                 arrayListOf())
         )),Faculty("Mass communication",R.drawable.mass, arrayListOf(
             Major("",
                 arrayListOf())
         )),Faculty("Foreign Languages",R.drawable.foregin, arrayListOf(
             Major("",
                 arrayListOf())
         )),Faculty("IT",R.drawable.computersciemce, arrayListOf(
             Major("",
                 arrayListOf())
         )),Faculty("Applied Medical Sciences",R.drawable.applied, arrayListOf(
             Major("",
                 arrayListOf())
         )),Faculty("Archeology and Tourist Guidance",R.drawable.tourist, arrayListOf(
             Major("",
                 arrayListOf())
         )),Faculty("Special Education",R.drawable.specialeducation, arrayListOf(
             Major("",
                 arrayListOf())
         )),Faculty("Engineering",R.drawable.engineer, arrayListOf(
             Major("",
                 arrayListOf())
         ))
         )
        adapter = FacultiesAdapter(faculties){ getSelectedIndex(it)}
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this,2)
        adapter.notifyDataSetChanged()
    }
    fun getSelectedIndex(index:Int){
        myIntent.putExtra(Constants.major,faculties[index].majors)


        startActivity(myIntent)
    }
    fun setUpOnClickAction() {
        /*businessEnglishBtn.setOnClickListener {
            val INFORMATIONSYSTEMSCourses:ArrayList<Course> =  arrayListOf(Course("Principles of Mathematics ", "MATH 101", "hello from description", "1", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","pre"),
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
                Course("Advanced Information System","INF 407","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"," 401"))

            val ACCOUNTINGCourses:ArrayList<Course> = arrayListOf(Course("Principles of Accounting","ACC 101","hello","1","hjfgs","NONE"),
                Course("Financial Accounting","ACC 102","hello from my descroption","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 101"),
                Course("Partnership Accounting","ACC 201","hello from dec","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102"),
                Course("Corporations Accounting","ACC 202","hello from my descroption","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102"),
                Course("Cost Accounting","ACC 301","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102,BUS 103"),
                Course("Specialized Accounting","ACC 302","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102"),
                Course("National and Governmental Accounting","ACC 303","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102"),
                Course("Auditing","ACC 304","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                Course("Tax Accounting (1)","ACC 305","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                Course("Tax Accounting (2)","ACC 401","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                Course("Cost Accounting Systems","ACC 402","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 301"),
                Course("Operation Research in Accounting","ACC 403","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 301"),
                Course("Financial Institutions Accounting","ACC 404","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202") ,
                Course("Accounting Information Systems","ACC 405","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                Course("Advanced Studies in Auditing","ACC 406","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 304"),
                Course("Advanced Studies in Cost Accounting","ACC 407","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 402"),
                Course("Managerial Accounting","ACC 408","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 301,BUS 304"),
                Course("International Accounting","Acc 409","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                Course("Accounting Problems","ACC 410","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 301,ACC 304"))

            val  FINANCEANDINVESTMENTSCourses:ArrayList<Course> = arrayListOf(Course("Financial Markets Theory","FIN 301","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Securities Intermediates","FIN 302","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201,ACC 202"),
                Course("Portfolio Management","FIN 303","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201,ACC 202,MATH 201"),
                Course("Monetary & Banking Policies","FIN 304","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201,ACC 202,MATH 201"),
                Course("International Monetary Funds","FIN 305","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Egyptian Stock Exchange","FIN 306","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202,MATH 201,ECO 202"),
                Course("Investments Banks","FIN 401","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 304"),
                Course("Specialized Banks","FIN 402","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 304"),
                Course("credit Management","FIN 403","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 304,ECO 302"),
                Course("International Finance","FIN 404","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 305"),
                Course("Operation Research im Finance & Investments","FIN 405","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","STS 201,BUS 304"),
                Course("Quantitative Methods in Stock Exchange","FIN 406","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 302,FIN 303,FIN 306,STS 201"),
                Course("The Central Banks","FIN 407","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 304,ECO 302"),
                Course("Finance and Investments Problems","FIN 408","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 304,ECO 302"),
                Course("Quantitative Methods in Banks & Portfolio","FIN 409","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 303,FIN 304,STS 201"),
                Course("Financial Policies for Institutions","FIN 413","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 304")
                )
            val BUSINESSADMINISTRATIONCourses:ArrayList<Course> = arrayListOf(Course("Principles of Management","BUS 101","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","NONE"),
                Course("Principles of Management","BUS 102","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Production Management","BUS 103","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Marketing","BUS 201","jdhdj","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Principles of Management","BUS 101","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Principles of Management","BUS 101","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Management Development","BUS 302","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Hospital Management","BUS 303","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Financial Management & Investment","BUS 304","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Specialized Institutions Management","BUS 305","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Small Business Administration","BUS 306","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Human Resource Management","BUS 307","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Managerial Problem","BUS 401","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Public Relations","BUS 402","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Financial Institution Management","BUS 403","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Business Strategies","BUS 404","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Management Information Systems","BUS 405","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Marketing Research & Advertising","BUS 406","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Communication","BUS 407","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Operations Research in Management","BUS 408","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                Course("Multinational Corporation Management","BUS 409","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201")
            )
            val ECONOMICSCourses:ArrayList<Course> = arrayListOf(Course("Principles of Management","BUS 101","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","NONE"))
            majors = arrayListOf(Major("Information systems", INFORMATIONSYSTEMSCourses),
                Major("accounting",ACCOUNTINGCourses), Major("finance",FINANCEANDINVESTMENTSCourses), Major("business",BUSINESSADMINISTRATIONCourses),Major("economics",ECONOMICSCourses)
            )
            myIntent.putExtra(Constants.major,majors)



            startActivity(myIntent)
            */

        }



}