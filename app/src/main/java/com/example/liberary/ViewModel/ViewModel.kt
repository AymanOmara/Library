package com.example.liberary.ViewModel


import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.liberary.Course
import com.example.liberary.LocalModel.LocalModel
import com.example.liberary.LocalModel.Shared
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single


class ViewModel:ViewModel() {
    private lateinit var shared:Shared

    fun initContext(context:AppCompatActivity){
        LocalModel.context = context
        Log.d("initContext","initContext")
        shared = Shared(context)
    }

    fun addToFavorite(course: Course): Flow<Boolean> {
        return  flow{
            emit(LocalModel.write(course).single())
        }
    }
    fun getData():Flow<ArrayList<Course>> {
        return flow{
            LocalModel.getAll().collect {
                emit(it)
            }
        }
    }
    fun clearAllData(){
            LocalModel.clearAll()
        }
     fun getPreferences():Flow<Prefs>{

        return flow {
            Log.d("my prefrences in view model","")
            emit(shared.getPrefrences().single())
        }
    }
    fun saveToPreferences(language:String){
        shared.savePrefrences(language)
    }
    fun saveDarkModeState(isDarkMode:Boolean){
        shared.saveDarkMode(isDarkMode)
    }
}
data class Prefs(val language: String,val isDarkMode:Boolean){}