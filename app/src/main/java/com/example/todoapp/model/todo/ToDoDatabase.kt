package com.example.todoapp.model.todo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ToDo:: class], version = 1, exportSchema = false)
abstract class ToDoDatabase: RoomDatabase() {
    abstract fun todoDAO(): ToDoDAO
}