package com.organisation.bazar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.organisation.bazar.screens.LoginScreen
import com.organisation.bazar.screens.OnBoardingScreen
import com.organisation.bazar.screens.RegisterScreen

@Composable
fun NavGraph() {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = "on_board_screen") {
    composable(route = "on_board_screen") { OnBoardingScreen(navController) }
    composable(route = "login") { LoginScreen(navController) }
    composable(route = "sign_up") { RegisterScreen(navController) }
  }
}
