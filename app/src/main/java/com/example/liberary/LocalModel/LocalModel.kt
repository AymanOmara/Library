package com.example.liberary.LocalModel

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.liberary.Course
import io.realm.Realm
import io.realm.kotlin.delete
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


object LocalModel{
    var context: AppCompatActivity? = null


   suspend fun write(course: Course): Flow<Boolean>{
        return flow {
            Realm.init(context)
            val realm = Realm.getDefaultInstance()
            var isBefore =  realm.where(Course::class.java).findAll().find { it.courseCode == course.courseCode }
            if (isBefore == null){
                realm.beginTransaction()
                realm.copyToRealm(course)
                realm.commitTransaction()
                emit(true)
            }else{
                emit(false)
            }
        }
    }

    suspend fun getAll() : Flow<ArrayList<Course>>{
        return  flow{
            Realm.init(context)
            val realm = Realm.getDefaultInstance()
            var da =  realm.where(Course::class.java).findAll()
            Log.d("model","${da.size}")
            emit(ArrayList(realm.copyFromRealm(da)))
        }
    }
     fun clearAll(){
            Realm.init(context)
            val realm = Realm.getDefaultInstance()
            realm.beginTransaction()
            realm.deleteAll()
            realm.commitTransaction()
    }
}

