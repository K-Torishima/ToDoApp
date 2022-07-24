package com.example.todoapp

import android.content.Context
import androidx.room.Room
import com.example.todoapp.model.todo.ToDoDAO
import com.example.todoapp.model.todo.ToDoDatabase
import com.example.todoapp.repository.todo.ToDoRepository
import com.example.todoapp.repository.todo.ToDoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent:: class)
object ToDoModule {

    @Singleton
    @Provides
    fun provideToDoDatabase( @ApplicationContext context: Context): ToDoDatabase {
        return Room.databaseBuilder(context, ToDoDatabase:: class.java, "todo.database").build()
    }

    @Singleton
    @Provides
    fun provideToDoDAO(database: ToDoDatabase): ToDoDAO {
        return  database.todoDAO()
    }
}

@Module
@InstallIn(SingletonComponent:: class)
abstract class ToDoRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindToDoRepository(impl: ToDoRepositoryImpl): ToDoRepository
}