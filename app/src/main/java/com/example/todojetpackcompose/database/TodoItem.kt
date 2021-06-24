package com.example.todojetpackcompose.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_item")
data class TodoItem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "item_id")
    var itemId: Long = 0L,

    @ColumnInfo(name = "item_name")
    val itemName:String,

    @ColumnInfo(name = "is_completed")
    var isDone:Boolean = false
)
