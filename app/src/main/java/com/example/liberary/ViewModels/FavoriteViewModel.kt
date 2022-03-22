package com.example.liberary.ViewModels

import androidx.lifecycle.ViewModel
import com.example.liberary.Course
import com.example.liberary.LocalModel.LocalModel

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach



class FavoriteViewModel:ViewModel() {
     fun getData(): kotlinx.coroutines.flow.Flow<ArrayList<Course>> {
        return flow{
            LocalModel.getAll().onEach {
                emit(it)
            }
        }
    }
}