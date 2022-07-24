package com.example.todoapp.page.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoDetailFragment: Fragment(R.layout.todo_detail_fragment) {

    private val viewModel: ToDoDetailViewModel by viewModels()
}