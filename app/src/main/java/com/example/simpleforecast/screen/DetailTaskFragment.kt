package com.example.simpleforecast.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.simpleforecast.databinding.FragmentDetailTaskBinding
import com.example.simpleforecast.screen.viewmodel.DetailTaskFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailTaskFragment : Fragment() {

    private var _binding: FragmentDetailTaskBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DetailTaskFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailTaskBinding.inflate(inflater, container, false)
        viewModel.retrieveHourlyForecast()
        return binding.root
    }

}