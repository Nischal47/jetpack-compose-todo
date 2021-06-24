package com.example.todojetpackcompose.database

import androidx.lifecycle.LiveData

class TodoRepository(private val todoDatabaseDao: TodoDatabaseDao) {
    val readAllData: LiveData<List<TodoItem>> = todoDatabaseDao.getAll()

    suspend fun addTodo(todoitem: TodoItem){
        todoDatabaseDao.insert(todoitem)
    }

    suspend fun updateTodo(todoitem: TodoItem){
        todoDatabaseDao.update(todoitem)
    }

    suspend fun deleteTodo(todoitem: TodoItem){
        todoDatabaseDao.delete(todoitem)
    }

    suspend fun deleteAllTodos(){
        todoDatabaseDao.deleteAllTodos()
    }
}