package com.example.todoapp.page.create

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateToDoFragment: Fragment(R.layout.create_todo_fragment) {

    private val viewModel: CreateToDoViewModel by viewModels()
}