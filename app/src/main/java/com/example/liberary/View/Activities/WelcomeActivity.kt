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
    private lateinit var majorsIntent : Intent
    private lateinit var faculties:ArrayList<Faculty>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        recyclerView = findViewById(R.id.faculties_rv)
        supportActionBar?.hide()
        initTheFaculties()
    }

    fun initTheFaculties(){
         faculties = arrayListOf(
             Faculty("Business English",R.drawable.business ,arrayListOf(
             Major("Information Systems", arrayListOf(Course("Principles of Mathematics ", "MATH 101", "hello from description", "1", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","None"),
                 Course("Financial Mathematics","MATH 201","hello from my descroption","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","Math 101"),
                 Course("Mathematical Insurance","MATH 401","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","Math 201, Sts 301"),
                 Course("Descriptive Statistics","STS 201","hello from dec","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","Math 101"),
                 Course("Applied Statistics","STS 301","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","Sts 201"),
                 Course("Advanced Statistics","STS 401","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","Sts 301, Math 201"),
                 Course("Introduction of Computer","COMP 102","hello from my descroption","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","None"),
                 Course("Principles of Information Systems","INF 201","hello from my descroption","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","COMP 102"),
                 Course("Principles of Programs Planning","INF 301","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201"),
                 Course("Basic of Systems Analysis","INF 302","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201"),
                 Course("Data Base","INF 303","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201"),
                 Course("Basics of Systems Design","INF 304","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 302"),
                 Course("Modern Programing Language","INF 305","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 301") ,
                 Course("Experts Systems and Decision Support System","INF 306","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 303") ,
                 Course("Information Centers Development","INF 401","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201"),
                 Course("Software in Business","INF 402","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201"),
                 Course("Management of Information Transfer Networks","INF 403","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201"),
                 Course("Systems Analysis & Design","INF 404","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 304"),
                 Course("DataBases Systems Problems","INF 405","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 303"),
                 Course("Medical Information Systems","INF 406","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 303"),
                 Course("Advanced Study in Operating Systems","INF 407","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201")))

         , Major("Finance and Investment",arrayListOf(Course("Financial Markets Theory","FIN 301","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Securities Intermediates","FIN 302","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202, ECO 201"),
                 Course("Portfolio Management","FIN 303","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201,ACC 202,MATH 201"),
                 Course("Monetary & Banking Policies","FIN 304","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201,ACC 202,MATH 201"),
                 Course("International Monetary Markets","FIN 305","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Egyptian Stock Exchange","FIN 306","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202,MATH 201,ECO 202"),
                 Course("Investments Banks","FIN 401","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 304"),
                 Course("Specialized Banks","FIN 402","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 304"),
                 Course("credit Management","FIN 403","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 302"),
                 Course("International Finance","FIN 404","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 305"),
                 Course("Operation Research in Finance & Investments","FIN 405","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","STS 201"),
                 Course("Quantitative Methods in Stock Exchange","FIN 406","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 302,FIN 303,FIN 306,STS 201"),
                 Course("Central Banks","FIN 407","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 302"),
                 Course("Finance and Investments Problems","FIN 408","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 302"),
                 Course("Quantitative Methods in Banks & Portfolio","FIN 409","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 303,STS 201"),
                 Course("Financial Policies for Institutions","FIN 413","jdhdj","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 304")))

         , Major("Accounting",arrayListOf(Course("Principles of Accounting","ACC 101","hello","1","hjfgs","NONE"),
                 Course("Financial Accounting","ACC 102","hello from my descroption","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 101"),
                 Course("Partnership Accounting","ACC 201","hello from dec","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102"),
                 Course("Corporations Accounting","ACC 202","hello from my descroption","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102"),
                 Course("Cost Accounting","ACC 301","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102,BUS 103"),
                 Course("Specialized Accounting","ACC 302","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102"),
                 Course("Governmental Accounting & National Accounting","ACC 303","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102"),
                 Course("Auditing","ACC 304","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                 Course("Tax Accounting (1)","ACC 305","hello from my descroption","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                 Course("Tax Accounting (2)","ACC 401","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                 Course("Cost Accounting Systems","ACC 402","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 301"),
                 Course("Operation Research in Accounting","ACC 403","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 301"),
                 Course("Financial Institutions Accounting","ACC 404","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202") ,
                 Course("Accounting Information Systems","ACC 405","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                 Course("Advanced Studies in Auditing","ACC 406","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 304"),
                 Course("Advanced Studies in Cost Accounting","ACC 407","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 402"),
                 Course("Management Accounting & Budgeting","ACC 408","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 301"),
                 Course("International Accounting","Acc 409","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                 Course("Accounting Problems","ACC 410","hello from my descroption","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 301,ACC 304")))
         ,
                 Major("Business Administration", arrayListOf(Course("Principles of Management","BUS 101","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","NONE"),
                 Course("Managerial Behaviour","BUS 102","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 101"),
                 Course("Production Management","BUS 103","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 101"),
                 Course("Marketing Management","BUS 201","jdhdj","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 101"),
                 Course("Purchasing & Warehousing Management ","BUS 202","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 101"),
                 Course("public & local Management","BUS 301","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 103,BUS 201,BUS 202"),
                 Course("Management Development","BUS 302","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 103,BUS 201,BUS 202"),
                 Course("Hospital Management","BUS 303","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 103,BUS 201,BUS 202"),
                 Course("Financial Management & Investment","BUS 304","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202,BUS 101,MATH 201"),
                 Course("Specialized Institutions Management","BUS 305","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 103,BUS 201, BUS 202"),
                 Course("Small Business Administration","BUS 306","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 103,BUS 201, BUS 202"),
                 Course("Human Resource Management","BUS 307","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 102"),
                 Course("Managerial Problems","BUS 401","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 302,BUS 307"),
                 Course("Public Relations","BUS 402","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 201"),
                 Course("Financial Institution Management","BUS 403","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 304"),
                 Course("Business Strategies","BUS 404","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 302,BUS 307"),
                 Course("Management Information Systems","BUS 405","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201"),
                 Course("Marketing Research & Advertising","BUS 406","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 201,STS 301"),
                 Course("Communications","BUS 407","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 307"),
                 Course("Operations Research in Management","BUS 408","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 103,MATH 201,STS 201"),
                 Course("Multinational Corporation Management","BUS 409","jdhdj","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 302,BUS 407")))
         ,
             Major("Economics", arrayListOf(
                 Course("Micro Economics","ECO101","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","NONE") ,
                 Course("Macro Economics","ECO 102","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 101"),
                 Course("Money and Banking","ECO 201","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 102"),
                 Course("Economic Resources","ECO 202","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 102"),
                 Course("Foreign Trade Theory","ECO 203","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 102"),
                 Course("Public Finance and Taxation","ECO 301","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 102"),
                 Course("Economic Feasibility Studies","ECO 302","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 102,ACC 202"),
                 Course("Economic Development and Planning","ECO 303","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 102"),
                 Course("Small Industries Economics","ECO 304","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 102"),
                 Course("Foreign Trade Policies","ECO 305","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 203"),
                 Course("Energy Economics","ECO 306","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 202"),
                 Course("International Economics Relations","ECO 307","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 203"),
                 Course("Global Economic Blocs","ECO 308","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 203"),
                 Course("Economic Information Systems","ECO 309","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 303") ,
                 Course("International Trade (Problems)","ECO 401","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 203"),
                 Course("Egyptian Economic (History)","ECO 402","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 102"),
                 Course("International Marketing","ECO 403","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 201,ECO 203"),
                 Course("History of Economic Thought","ECO 404","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 305"),
                 Course("Contemporary Economic Systems","ECO 405","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 303"),
                 Course("Econometrics","ECO 406","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 303,STS 201"),
                 Course("National Accounts","ECO 407","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 303"),
                 Course("Contemporary Economic Problems","ECO 408","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 303"),
                 Course("Arab Countries Economics","ECO 409","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 303"),
                 Course("Multinational Corporations","ECO 410","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 307"),))
         ,
             Major("Political Science",arrayListOf(Course("Introduction to Law","LAW 101","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","NONE") ,
                 Course("Commercial Law","LAW 201","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","LAW 101"),
                 Course("Public International Law","Law 303","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","LAW 101,POL 201"),
                 Course("Conflicts & Arbitration","LAW 401","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","LAW 303"),
                 Course("Political Science (1)","POL 101","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","NONE"),
                 Course("Introduction to Political Science (2)","POL 201","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","POL 101"),
                 Course("History of Political Thought","POL 301","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","POL 201"),
                 Course("Theory of Comparative Political Systems","POL 302","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","POL 201"),
                 Course("Theory of International Relations","POL 303","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","POL 201"),
                 Course("International Organizations","POL 304","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","POL 201"),
                 Course("International Relations in the 20th Cent","POL 305","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","POL 201"),
                 Course("Diplomatic and Consular Systems","POL 306","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","POL 201"),
                 Course("Political Theory","POL 307","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","POL 201"),
                 Course("Egyptian Political Systems","POL 401","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","POL 302"),
                 Course("Comparative Political Systems","POL 402","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","POL 302"),
                 Course("Political Development","POL 403","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","POL 302"),
                 Course("Foregin Policies of Major Powers","POL 404","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","POL 305"),
                 Course("Political Problems in the Arab World","POL 405","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","POL 305"),
                 Course("Contemporary Issues in World Politics","POL 406","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","POL 305"),
                 Course("Regional Organizations","POL 407","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","POL 304"),
                 Course("Egyptian Foreign Policy","POL 408","jdhdj","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","POL 305"))))

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
        majorsIntent = Intent(this, MajorsActivity::class.java)
        majorsIntent.putExtra(Constants.major,faculties[index].majors)
        startActivity(majorsIntent)
    }
}