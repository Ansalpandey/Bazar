package com.organisation.bazar.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.organisation.bazar.viewmodel.AuthViewModel

@Composable
fun HomeScreen(navController: NavHostController) {
  val authViewModel: AuthViewModel = viewModel()
  val firebaseUser by authViewModel.firebaseUser.observeAsState()

  if (firebaseUser == null) {
    navController.navigate("on_board_screen")
  }
  Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = "Logout",
      modifier =
        Modifier.clickable {
          authViewModel.logout()
          navController.popBackStack()
          navController.navigate("login")
        },
      fontSize = 52.sp
    )
  }
}
