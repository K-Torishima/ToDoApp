package com.example.todoapp.page.edit

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditToDoFragment: Fragment(R.layout.edit_todo_fragment) {

    private val viewModel: EditToDoViewModel by viewModels()
}