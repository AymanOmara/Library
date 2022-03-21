package com.example.liberary.LocalModel

import com.example.liberary.Course
import io.realm.Realm
import io.realm.kotlin.where

class LocalModel{
    //private val realm = Realm.init()

    fun write(course: Course){
        val realm =  Realm.getDefaultInstance()

        //realm.where<Course>().findAll()
        //realm.writeBlocking {
        //  copyToRealm(course)
        //}
    }
    fun getAll(){
        //realm.query<Course>().find()
        //Log.d("realm", realm.query<Course>().count().toString())
    }
}
