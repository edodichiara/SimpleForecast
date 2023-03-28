package com.example.simpleforecast.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.simpleforecast.databinding.FragmentGraphTaskBinding
import com.example.simpleforecast.screen.viewmodel.GraphTaskFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GraphTaskFragment : Fragment() {

    private var _binding: FragmentGraphTaskBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GraphTaskFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGraphTaskBinding.inflate(inflater, container, false)
        viewModel.retrieveHourlyForecast()
        return binding.root
    }
}