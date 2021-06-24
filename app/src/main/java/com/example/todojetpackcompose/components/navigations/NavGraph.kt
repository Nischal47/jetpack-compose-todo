package com.example.todojetpackcompose.components.navigations

import androidx.navigation.NavController
import com.example.todojetpackcompose.components.navigations.Destinations.AddTodo

class NavGraph(navController: NavController) {
    val addTodo: () -> Unit = {
        navController.navigate(AddTodo)
    }
}

object Destinations {
    const val Home = "home"
    const val AddTodo = "addTodo"
}