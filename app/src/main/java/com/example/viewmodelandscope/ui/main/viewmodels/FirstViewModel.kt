package com.example.viewmodelandscope.ui.main.viewmodels

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FirstViewModel(application: Application) : AndroidViewModel(application) {
    companion object {
        private const val TAG: String = "로그"    
    }
    
    override fun onCleared() {
        Log.d(TAG,"MainViewModel - onCleared() called")
        super.onCleared()
    }
    
    fun doNetworkThing() {
        Log.d(TAG,"MainViewModel - doNetworkThing() called")
        viewModelScope.launch(Dispatchers.IO) {
            delay(4000)
            withContext(Dispatchers.Main) {
                Toast.makeText(getApplication(), "Network job is done!", Toast.LENGTH_SHORT).show()
            }
            Log.d(TAG,"MainViewModel - doNetworkThing() end")
        }
    }
}