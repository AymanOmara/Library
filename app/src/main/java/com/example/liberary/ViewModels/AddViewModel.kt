package com.example.liberary.ViewModels

import androidx.lifecycle.ViewModel
import com.example.liberary.Course
import com.example.liberary.LocalModel.LocalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single


class AddViewModel:ViewModel() {
    fun addToFavorite(course: Course): Flow<Boolean> {
        return  flow{
        emit(LocalModel.write(course).single())
        }

    }
}