package com.example.liberary


import android.util.Log

import io.realm.*
import io.realm.annotations.PrimaryKey
import io.realm.query
import java.io.Serializable
import java.util.*

data class Major(val majorName:String,val courses: ArrayList<Course>):Serializable{}

data class Course(val courseName:String,val courseCode:String,val courseDescription:String,val level:String,val refreces:String,val preRequest:String):Serializable{

}
class LocalModel{
    private val realmConfiguration = RealmConfiguration.with(schema = setOf(Dog::class))
    //private val realm = Realm.open(realmConfiguration)
    fun write(course:Course){

        //realm.writeBlocking {
          //  copyToRealm(course)
        //}
    }
    fun getAll(){
        //realm.query<Course>().find()
        //Log.d("realm", realm.query<Course>().count().toString())
    }
}
class Dog: RealmObject {
    @PrimaryKey
    var name = ""
}