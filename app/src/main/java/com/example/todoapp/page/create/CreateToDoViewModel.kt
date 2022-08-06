package com.example.todoapp.page.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.repository.todo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class CreateToDoViewModel @Inject constructor(private val repository: ToDoRepository): ViewModel() {
    val errorMessage = MutableLiveData<String>()
    val done = MutableLiveData<Boolean>()

    fun save(title: String, detail: String) {
        // タイトルが空ならError
        if (title.trim().isEmpty()) {
            errorMessage.value = "Please input title"
            return
        }
        // リポジトリ経由で実際の保存処理を行う
        viewModelScope.launch {
            try {
                repository.create(title, detail)
                done.value = true
            } catch (e: Exception) {
                errorMessage.value = e.message
            }
        }
    }
}