package com.example.liberary

import java.io.Serializable

data class Course(val courseName:String,val courseCode:String,val courseDescription:String,val level:String,val refreces:String):Serializable {
}
data class Major(val majorName:String,val courses:ArrayList<Course>):Serializable{}