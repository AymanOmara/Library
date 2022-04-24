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
             Major("Information Systems", arrayListOf(Course("Principles of Mathematics ", "MATH 101", "NONE", "1", "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","None"),
                 Course("Financial Mathematics","MATH 201","NONE","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","Math 101"),
                 Course("Mathematical Insurance","MATH 401","NONE","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","Math 201, Sts 301"),
                 Course("Descriptive Statistics","STS 201","Descriptive Statistics course,makes the student familiar with the most important statistics used to describing data in a form that is easy to understand.","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","Math 101"),
                 Course("Applied Statistics","STS 301","The aim of applied statistics course is to make the students familiar with modern techniques and methods essential to most successful managers and decision makers.","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","Sts 201"),
                 Course("Advanced Statistics","STS 401","The aim of advanced statistics course is to make the students familiar with different techniques which is essential to most successful decision-makers. ","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","Sts 301, Math 201"),
                 Course("Introduction of Computer","COMP 102","This course introduce computer hardware,software,procedures,systems,and human resources and explores their integration and application in business and other segments of society.","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","None"),
                 Course("Principles of Information Systems","INF 201","This course consists of an overview of the various components of a comprehensive information infrastructure including computing platforms,software architectures,and telecommunications networks.","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","COMP 102"),
                 Course("Principles of Programs Planning","INF 301","This course presents object-oriented and procedural software engineering methodologies in data definition and measurement, abstract data type construction,and use in developing screens,reports,and other IS applications problems .","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201"),
                 Course("Basic of Systems Analysis","INF 302","This course offers an overview of the system development life cycle. Discussion of the information gathering and reporting activities and the transition from analysis to design is given","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201"),
                 Course("Data Base","INF 303","The course provides a general overview of database management systems (DBMS) and emphasizes the development of applications for managerial decision-making . it offers study of concepts,theory,design techniques and retrieval methods,particularly using the industry-standard SQL data language. ","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201"),
                 Course("Basics of Systems Design","INF 304","This course provides an introduction to the systems development life cycle,with emphasis on the design phase. structured methodologies utilizing CASE tools, as well as prototyping techniques,are covered.","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 302"),
                 Course("Modern Programing Language","INF 305","This course covers the history,theory, and practice of modern programming languages,with emphasis on markup languages and their associated scripting languages.","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 301") ,
                 Course("Experts Systems and Decision Support System","INF 306","This course covers Decision Support Systems and Experts Systems in roughly equal measure .Issues that integrate the two fields,such as Executive Information Systems are addressed briefly.","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 303") ,
                 Course("Information Centers Development","INF 401","This course covers the topics related to the running and maintenance of information center, and describe the different organization charts of information center and the impact on the organization.","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201"),
                 Course("Software in Business","INF 402","This course introduces the development of business-oriented application programs, using case studies to stress the principles of good program design. Application software includes, but may not be limited to Microsoft Office.","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201"),
                 Course("Management of Information Transfer Networks","INF 403","This course analyzes historical and current developments impacting the evolution of telecommunications. Video,voice and data technologies are studied, including analog, digital, satellite, and wireless communications. ","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201"),
                 Course("Systems Analysis & Design","INF 404","This course provides a survey of human-computer interaction and of all facts human factors relevant to the design, development, and use of Information Systems.It describes the contributions of information systems, computer science, psychology, sociology, and engineering to human-computer interaction.","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 304"),
                 Course("DataBases Systems Problems","INF 405","The course offers hands-on experience for developing client/server database applications using a major database management system. Students learn how to create and manipulate database objects including tables, views, and sequences;develop program units using SQL; and implement client applications such as forms and reports.","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 303"),
                 Course("Medical Information Systems","INF 406","The focus of this course is on health care information systems in the local area or enterprise environment. Topics include computerized patient records, survey applications in the health care specialties, decision support systems, clinical information system design architectures, and computer-based training for patients and providers. ","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 303"),
                 Course("Advanced Study in Operating Systems","INF 407","This course provides coverage of the design and implementation of general purpose multitasking operating systems.","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","INF 201")))

         , Major("Finance and Investment",arrayListOf(Course("Financial Markets Theory","FIN 301","This course is designed to provide students with concepts and practices of the financial market theory.","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Securities Intermediates","FIN 302","This course explains the role of money and capital markets,which deals with securities, markets and financial institutions including banks,insurance companies,mutual funds,and investment banking firms ","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202, ECO 201"),
                 Course("Portfolio Management","FIN 303","This course is intended to emphasize on consideration of portfolios rather than of individual securities held by individuals or institutions","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201,ACC 202,MATH 201"),
                 Course("Monetary & Banking Policies","FIN 304","This course is designed to help students understand the capital market structure, financial policies and techniques ","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201,ACC 202,MATH 201"),
                 Course("International Monetary Markets","FIN 305","This course aim to introduce the main concepts of the international monetary funds,analysis and evaluation.","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 201"),
                 Course("Egyptian Stock Exchange","FIN 306","This course deals with investments in securities quoted on the egyptian stock exchange(ESE),explain the financial investments directly and indirectly bounds and stocks (securities) ","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202,MATH 201,ECO 202"),
                 Course("Investments Banks","FIN 401","This course explains the role of the investment banks and establishing new projects or expanding the existing projects.","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 304"),
                 Course("Specialized Banks","FIN 402","The aim of this course is to provide the student with the basic knowledge needed to cover the banking system,banking activities and various kinds of specialized banks","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 304"),
                 Course("credit Management","FIN 403","This course is designed to provide students with concepts and the main principles of credit management It highlights the type of credit and credit policies and financial analysis for granting credits.","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 302"),
                 Course("International Finance","FIN 404","This course deals with the main concepts of international finance, international monetary funds and foreign investment.","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 305"),
                 Course("Operation Research in Finance & Investments","FIN 405","This course is an introduction intended to solve quantitative problems and offers a review of techniques that can be used in quantitative analysis in finance and investment. ","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","STS 201"),
                 Course("Quantitative Methods in Stock Exchange","FIN 406","The objective of this course is to highlight how to use the quantitative analysis and techniques to support and enhance decision associated with stock exchange.","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 302,FIN 303,FIN 306,STS 201"),
                 Course("Central Banks","FIN 407","This course is an intro to C.B systems, the need for central banks, the C.B functions, the C.B responsibilities","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 302"),
                 Course("Finance and Investments Problems","FIN 408","This course serves as an indicator of the financial system development.","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ECO 302"),
                 Course("Quantitative Methods in Banks & Portfolio","FIN 409","The objective of this course is to qualify the students in mastering the most useful quantitative and practical techniques that are being used in banks, portfolio and financial markets.","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","FIN 303,STS 201"),
                 Course("Financial Policies for Institutions","FIN 413","This course explains the financial analysis, determining financial needs and requirements","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 304")))

         , Major("Accounting",arrayListOf(Course("Principles of Accounting","ACC 101","This course introduces students to accounting, its concepts and principles. It focuses,however, on the accounting cycle and the preparation of financial statements.","1","hjfgs","NONE"),
                 Course("Financial Accounting","ACC 102","The objective of this course is to enhance the understanding of the financial statements prepared by the accountants.It covers, in detail , the balance sheet elements including current and non-current assets,liabilities and owner's equity.","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 101"),
                 Course("Partnership Accounting","ACC 201","The objective of this course is to provide deep understanding of the nature and features of partnership from business and the application of different accounting assumptions, principles and concepts.","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102"),
                 Course("Corporations Accounting","ACC 202","The objective of this course is to provide deep understanding of accounting issues involved in the formation, operations and liquidation of the corporations.","2","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102"),
                 Course("Cost Accounting","ACC 301","The objective of this course is to introduce students to cost accounting, cost behaviour,costing methods and overhead allocations.","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102,BUS 103"),
                 Course("Specialized Accounting","ACC 302","This course covers a variety of subjects.Examples of these are divisionalized enterprises","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102"),
                 Course("Governmental Accounting & National Accounting","ACC 303","This course is designed to illustrate some fundamental concepts of government and national accounting systems.Government accounting deals with budgeting and its approaches,line item budget,PPBs,PB and ZBB,budgetary control and accounting cycle","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 102"),
                 Course("Auditing","ACC 304","An introduction to the basic principles of auditing.(audit reports, audit responsibilities and objectives,audit evidence, internal control and control risk)","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                 Course("Tax Accounting (1)","ACC 305","The course introduces students to the tax system applied in egypt and its evolution since 1939.","3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                 Course("Tax Accounting (2)","ACC 401","It explains the tax on natural person's income and how the students can be prepare the tax declaration and the adjustments made in accounting net profit to be taxable net profit ","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                 Course("Cost Accounting Systems","ACC 402","This course helps the students to understand and learn Break-even analysis and cost volume. profit analysis","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 301"),
                 Course("Operation Research in Accounting","ACC 403","The aim of this course is to provide a complete and modern treatment of basic methodology.","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 301"),
                 Course("Financial Institutions Accounting","ACC 404","This course deals with the environment, regulations and accounting treatments of the financial institutions, banking and insurance companies.","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202") ,
                 Course("Accounting Information Systems","ACC 405","This course helps the students to understand and learn overview of information systems and accounting, environments of information system,managerial decision-making and information processing, reporting ","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                 Course("Advanced Studies in Auditing","ACC 406","An advanced study of (auditing) topics of significance for a student who has an idea about the basic principles of auditing.","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 304"),
                 Course("Advanced Studies in Cost Accounting","ACC 407","This course helps the students to understand and learn Standard costs, analysis of cost variances, activity-based costing systems","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 402"),
                 Course("Management Accounting & Budgeting","ACC 408","This course is intended to introduce students to managerial accounting .The course comprises budgeting system,accounting information for decision-making,financial analysis and internal performance evaluation","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 301"),
                 Course("International Accounting","Acc 409","This course presents international accounting within the context of the managing multinational enterprises and how it is practiced worldwide.","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 202"),
                 Course("Accounting Problems","ACC 410","The objectives of this course is to study advanced topics in accounting related to department and branches,combinations and consolidation, the accounting concept and problems involved are discussed and solutions are provided.","4","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","ACC 301,ACC 304")))
         ,
                 Major("Business Administration", arrayListOf(Course("Principles of Management","BUS 101","Introducing students to the basic knowledge and concepts of management through twofold approach ,first selected contributors of management theory.second management functions and managerial roles ","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","NONE"),
                 Course("Managerial Behaviour","BUS 102","An introduction of the field of O.B. it deals with the subjection three levels","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 101"),
                 Course("Production Management","BUS 103","This course intended as an introduction to the field of production and quantitative management ","1","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf","BUS 101"),
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