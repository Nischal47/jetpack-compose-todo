package com.example.todojetpackcompose.components.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todojetpackcompose.HomeView
import com.example.todojetpackcompose.components.addTodo.AddView
import com.example.todojetpackcompose.ui.theme.TodoJetPackComposeTheme


@Composable
fun NavigationComponent() {
    val navController = rememberNavController()

    TodoJetPackComposeTheme {
        NavHost(navController = navController, startDestination = Destinations.Home) {
            composable(Destinations.Home) { HomeView(navController) }
            composable(Destinations.AddTodo) { AddView(navController) }
        }
    }
}