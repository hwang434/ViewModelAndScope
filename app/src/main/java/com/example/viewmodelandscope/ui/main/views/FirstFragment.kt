package com.example.viewmodelandscope.ui.main.views

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.viewmodelandscope.R
import com.example.viewmodelandscope.databinding.FragmentFirstBinding
import com.example.viewmodelandscope.ui.main.viewmodels.FirstViewModel

class FirstFragment : Fragment() {

    companion object {
        private const val TAG: String = "로그"
    }

    private lateinit var viewModel: FirstViewModel
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG,"FirstFragment - onCreateView() called")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application = requireActivity().application).create(FirstViewModel::class.java)
        setEvent()
        return binding.root
    }

    private fun setEvent() {
        Log.d(TAG,"FirstFragment - setEvent() called")
        binding.buttonDoNetwrodk.setOnClickListener {
            viewModel.doNetworkThing()
        }
    }
}