package com.example.liberary


import io.realm.*
import io.realm.kotlin.where
import java.io.Serializable
import java.util.*


data class Major(val majorName:String,val courses: ArrayList<Course>):Serializable{}

data class Course(val courseName:String,val courseCode:String,val courseDescription:String,val level:String,val refreces:String,val preRequest:String):Serializable{

}