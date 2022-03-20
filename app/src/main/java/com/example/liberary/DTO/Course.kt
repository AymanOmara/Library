package com.example.liberary


import io.realm.*
import io.realm.kotlin.where
import java.io.Serializable
import java.util.*


data class Major(val majorName:String,val courses: ArrayList<Course>):Serializable{}

data class Course(val courseName:String,val courseCode:String,val courseDescription:String,val level:String,val refreces:String,val preRequest:String):Serializable{

}
class LocalModel{
    //private val realm = Realm.init()
    //private val realmConfig = RealmConfiguration.
    //private val realmConfiguration = RealmConfiguration.with(schema = setOf(Dog::class))
//    private val realm = Realm.open(realmConfiguration)
    fun write(course:Course){
        val realm =  Realm.getDefaultInstance()

        realm.where<Dog>().findAll()
        //realm.writeBlocking {
          //  copyToRealm(course)
        //}
    }
    fun getAll(){
        //realm.query<Course>().find()
        //Log.d("realm", realm.query<Course>().count().toString())
    }
}
 open class Dog: RealmObject() {
    var name:String = ""
}

