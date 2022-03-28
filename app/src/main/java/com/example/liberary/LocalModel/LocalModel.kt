package com.example.liberary.LocalModel

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.liberary.Course
import io.realm.Realm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object LocalModel{
    var context: AppCompatActivity? = null

   suspend fun write(course: Course): Flow<Boolean>{
        return flow {
            Realm.init(context)
            val realm = Realm.getDefaultInstance()
            if(course.isRecent){
                realm.beginTransaction()
                realm.copyToRealm(course)
                realm.commitTransaction()
                emit(true)
            }else{
                val isBefore = realm.where(Course::class.java).findAll().find { it.courseCode == course.courseCode && !it.isRecent}

                if (isBefore == null && !course.isRecent){
                    realm.beginTransaction()
                    realm.copyToRealm(course)
                    realm.commitTransaction()
                    emit(true)
                }else{
                    emit(false)
                    Log.d("my recent Model Value","${isBefore?.courseCode} ${isBefore?.isRecent}")
                }
            }
        }
    }

    suspend fun getAll() : Flow<ArrayList<Course>>{
        return  flow{
            Realm.init(context)
            val realm = Realm.getDefaultInstance()
            val da = realm.where(Course::class.java).findAll()

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
    fun removeRecent() {
        Realm.init(context)
        val realm = Realm.getDefaultInstance()
        val obj = realm.where(Course::class.java).findAll().find { it.isRecent }
        realm.beginTransaction()
        obj?.deleteFromRealm()
        realm.commitTransaction()
    }
}

