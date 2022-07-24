package com.example.todoapp.repository.todo

// 定義クラス
interface ToDoRepository {
    suspend fun create(title: String, detail: String)

}