package com.example.liberary.ViewModels

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.liberary.Course
import com.example.liberary.LocalModel.LocalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.single


class ViewModel:ViewModel() {
    fun initContext(context:AppCompatActivity){
        LocalModel.context = context
    }

    fun addToFavorite(course: Course): Flow<Boolean> {
        return  flow{
        emit(LocalModel.write(course).single())
        }

    }
    fun getData():Flow<ArrayList<Course>> {
        return flow{
            LocalModel.getAll().collect() {
                Log.d("the last View model","${it.size}")
                emit(it)
            }
        }
    }
}