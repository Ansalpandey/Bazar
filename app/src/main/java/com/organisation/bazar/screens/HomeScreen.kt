package com.organisation.bazar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.organisation.bazar.R
import com.organisation.bazar.ui.theme.MainColor
import com.organisation.bazar.ui.theme.RobotoFamily
import com.organisation.bazar.viewmodel.AuthViewModel

@Composable
fun HomeScreen(navController: NavHostController) {
  val authViewModel: AuthViewModel = viewModel()
  val firebaseUser by authViewModel.firebaseUser.observeAsState()

  if (firebaseUser == null) {
    navController.navigate("on_board_screen")
  }
}

@Composable
fun MainHome() {
  LazyColumn {
    item {
      Row(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Image(
          painter = painterResource(id = R.drawable.search),
          contentDescription = "search",
          modifier = Modifier.size(32.dp).clickable {}
        )
        Text(
          text = "Home",
          fontSize = 20.sp,
          fontFamily = RobotoFamily,
          fontWeight = FontWeight.Bold,
          color = Color.Black
        )
        Image(
          painter = painterResource(id = R.drawable.notification),
          contentDescription = "notifications",
          modifier = Modifier.size(32.dp).clickable {}
        )
      }
      Row(modifier = Modifier.padding(top = 40.dp)) {
        Column() {
          Text(
            text = "Special Offer",
            fontSize = 20.sp,
            fontFamily = RobotoFamily,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(start = 30.dp)
          )
          Text(
            text = "Discount 25%",
            fontSize = 14.sp,
            fontFamily = RobotoFamily,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            modifier = Modifier.padding(start = 30.dp, bottom = 30.dp)
          )
          Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(MainColor),
            modifier = Modifier.width(200.dp).height(50.dp).padding(start = 30.dp)
          ) {
            Text(
              text = "Order Now",
              fontSize = 14.sp,
              color = Color.White,
              fontFamily = RobotoFamily,
              fontWeight = FontWeight.Bold
            )
          }
        }
        Image(
          painter = painterResource(id = R.drawable.poster_image),
          contentDescription = "poster Image",
          modifier = Modifier.height(145.dp).width(200.dp)
        )
      }
      Row(
        modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp, top = 20.dp),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
      ) {
        Text(
          text = "Top of Week",
          fontSize = 18.sp,
          fontWeight = FontWeight.Bold,
          fontFamily = RobotoFamily,
          color = Color.Black
        )
        Text(
          text = "See all",
          fontSize = 14.sp,
          fontWeight = FontWeight.Bold,
          fontFamily = RobotoFamily,
          color = MainColor
        )
      }
      Spacer(modifier = Modifier.height(20.dp))
      BookList("$14.99")
    }
  }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainHomePreview() {
  MainHome()
}
