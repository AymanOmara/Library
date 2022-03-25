package com.example.liberary.LocalModel

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.liberary.ViewModel.Prefs
import com.example.liberary.constants.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Shared(var context: AppCompatActivity) {
    private val sharedPreference=this.context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
    private var editor:SharedPreferences.Editor = sharedPreference.edit()

    fun savePrefrences(language:String){
        editor.putString(Constants.language,language)
        editor.commit()
    }
    fun saveDarkMode(isDark:Boolean){
        editor.putBoolean(Constants.darkMode,isDark)
        editor.commit()
    }
    fun getPrefrences(): Flow<Prefs> {
        return flow {

            val str = sharedPreference.getString(Constants.language, "en")
            emit(Prefs(sharedPreference.getString(Constants.language,Constants.noData)!!,
                sharedPreference.getBoolean(Constants.darkMode, false)
            ))
        }
    }
}