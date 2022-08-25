package com.example.viewmodelandscope.ui.main.views

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewmodelandscope.R
import com.example.viewmodelandscope.ui.main.viewmodels.SecondViewModel

class SecondFragment : Fragment() {
    private lateinit var viewModel: SecondViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)

        return inflater.inflate(R.layout.fragment_second, container, false)
    }
}