package com.example.liberary.ViewModel


import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.liberary.Course
import com.example.liberary.DTO.Prefs
import com.example.liberary.LocalModel.LocalModel
import com.example.liberary.LocalModel.Shared
import kotlinx.coroutines.flow.*


class ViewModel:ViewModel() {
    private lateinit var shared:Shared

    fun initContext(context:AppCompatActivity){
        LocalModel.context = context
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
            removeAllShared()
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
    fun removeAllShared(){
        shared.removeAllShared()
    }
    fun getOPendRecent():Flow<ArrayList<Course>> {
    return flow {
        val recentOnly = ArrayList<Course>()
        getData().collect {
            it.map {
                if(it.isRecent){
                    recentOnly.add(it)
                }
            }
        }
        emit(recentOnly)
    }
    }
    fun removeRecent(course:Course){
        LocalModel.removeRecent(course)
    }


}