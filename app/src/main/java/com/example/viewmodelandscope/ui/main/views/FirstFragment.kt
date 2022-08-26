package com.example.viewmodelandscope.ui.main.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.viewmodelandscope.R
import com.example.viewmodelandscope.databinding.FragmentFirstBinding
import com.example.viewmodelandscope.ui.main.viewmodels.FirstViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstFragment : Fragment() {

    companion object {
        private const val TAG: String = "로그"
    }

    private val viewModel: FirstViewModel by viewModels()
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG,"FirstFragment - onCreateView() called")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        setEvent()
        return binding.root
    }

    // 이벤트를 설정.
    private fun setEvent() {
        Log.d(TAG,"FirstFragment - setEvent() called")
        // 버튼을 누르면 4초에 딜레이가 걸리는 네트워크 작업을 실행.
        binding.buttonDoNetwrodk.setOnClickListener {
            doNetworkJob()
        }
    }

    // 시간이 4초 걸리는 네트워크 작업
    private fun doNetworkJob() {
        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.doNetworkThing()
        }
    }

    // 프래그먼트에 종속 되는 뷰모델들을 clear.
    private fun clearTheViewModelStore() {
        Log.d(TAG,"FirstFragment - clearTheViewModelStore() called")
        viewModelStore.clear()
    }
}