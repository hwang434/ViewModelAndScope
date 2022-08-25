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

    // 뷰모델이 cleared 되면 toast 띄워줌.
    override fun onCleared() {
        Log.d(TAG,"MainViewModel - onCleared() called")
        super.onCleared()
        Toast.makeText(getApplication(), "FirstViewModel is cleared.", Toast.LENGTH_SHORT).show()
    }

    // 4초에 딜레이가 있는 네트워크 작업.
    fun doNetworkThing() {
        Log.d(TAG,"MainViewModel - doNetworkThing() called")
        // 뷰모델의 onCleared()가 불리기 전까지 계속 진행 된다.
        viewModelScope.launch(Dispatchers.IO) {
            delay(5000)
            withContext(Dispatchers.Main) {
                Toast.makeText(getApplication(), "Network job is done!", Toast.LENGTH_SHORT).show()
            }
            Log.d(TAG,"MainViewModel - doNetworkThing() end")
        }
    }
}