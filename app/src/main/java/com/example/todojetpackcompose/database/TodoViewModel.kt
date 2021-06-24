package com.example.todojetpackcompose.database

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<TodoItem>>
    private val repository: TodoRepository

    init {
        val todoDao = TodoDatabase.getInstance(application).todoDao()
        repository = TodoRepository(todoDao)
        readAllData = repository.readAllData
    }

    fun addTodo(todoitem: TodoItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTodo(todoitem)
        }
    }

    fun updateTodo(todoitem: TodoItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTodo(todoitem)
        }
    }

    fun deleteTodo(todoitem: TodoItem){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTodo(todoitem = todoitem)
        }
    }

    fun deleteAllTodos() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllTodos()
        }
    }
}

class TodoViewModelFactory(private val application: Application) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(TodoViewModel::class.java)){
            return TodoViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}