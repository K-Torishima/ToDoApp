package com.example.todoapp.repository.todo

import com.example.todoapp.model.todo.ToDo
import com.example.todoapp.model.todo.ToDoDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ToDoRepositoryImpl @Inject constructor(private val dao: ToDoDAO): ToDoRepository {
    override suspend fun create(title: String, detail: String) {
        val now = System.currentTimeMillis()
        val todo = ToDo(title = title, detail = detail, created = now, modified = now)
        withContext(Dispatchers.IO) {
            dao.create(todo)
        }
    }
}