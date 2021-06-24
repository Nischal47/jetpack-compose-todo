package com.example.todojetpackcompose.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDatabaseDao {
    @Query("Select * FROM todo_item")
    fun getAll(): LiveData<List<TodoItem>>

    @Query("SELECT * FROM todo_item where item_id = :id")
    fun getById(id: Int): TodoItem?

    @Insert
    suspend fun insert(item: TodoItem)

    @Update
    suspend fun update(item: TodoItem)

    @Delete
    suspend fun delete(item: TodoItem)

    @Query("DELETE FROm todo_item")
    suspend fun deleteAllTodos()

}