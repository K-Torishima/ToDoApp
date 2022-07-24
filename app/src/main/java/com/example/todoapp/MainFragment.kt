package com.example.todoapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment: Fragment(R.layout.main_fragment) {
    private val viewModel: MainViewModel by viewModels()
}
