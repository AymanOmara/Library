package com.example.liberary.LocalModel

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.liberary.Course
import io.realm.Realm
import kotlinx.coroutines.flow.Flow


object LocalModel{
    var context: AppCompatActivity? = null


    fun write(course: Course){
        Realm.init(context)
        val realm = Realm.getDefaultInstance()
        var isBefore =  realm.where(Course::class.java).findAll().find { it.courseCode == course.courseCode }
        if (isBefore == null){
            realm.beginTransaction()
            realm.copyToRealm(course)
            realm.commitTransaction()
        }else{
            Log.d("error","error")
        }



    }
    fun getAll(){
        //: Flow<ArrayList<Course>>
        Realm.init(context)
        val realm = Realm.getDefaultInstance()
        var da =  realm.where(Course::class.java).findAll()
        Log.d("realm data","${da.size}")

       // return realm.where(Course::class.java).findAll()
    }
}

