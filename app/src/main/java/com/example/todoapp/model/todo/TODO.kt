package com.example.todoapp.model.todo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val detail: String,
    val created: Long,
    val modified: Long,
)