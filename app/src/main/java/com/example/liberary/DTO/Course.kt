package com.example.liberary


import io.realm.*
import io.realm.annotations.PrimaryKey
import io.realm.kotlin.where
import java.io.Serializable
import java.util.*


data class Major(val majorName:String,val courses: ArrayList<Course>):Serializable{}

open class Course(): RealmObject(),Serializable{
    var isRecent:Boolean = false
    var courseName:String = ""
    var courseCode:String = ""
    var courseDescription:String = ""
    var level:String = ""
    var refreces:String = ""
    var preRequest:String = ""
    constructor(courseName:String, courseCode:String, courseDescription:String, level:String, refreces:String, preRequest:String) : this() {
        this.courseName =  courseName
        this.courseCode = courseCode
        this.courseDescription = courseDescription
        this.level = level
        this.preRequest = preRequest
        this.refreces = refreces
    }
    }