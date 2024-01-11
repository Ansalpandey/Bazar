package com.organisation.bazar.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.organisation.bazar.R
import com.organisation.bazar.ui.theme.MainColor
import com.organisation.bazar.ui.theme.RobotoFamily
import com.organisation.bazar.viewmodel.AuthViewModel
import kotlinx.coroutines.launch

data class OnBoardScreenItems(
  val title: String,
  @DrawableRes val image: Int,
  val description: String,
)

fun getList(): List<OnBoardScreenItems> {
  return listOf(
    OnBoardScreenItems(
      "Now reading books will be easier",
      R.drawable.onboard_one,
      " Discover new worlds, join a vibrant reading community. Start your reading adventure effortlessly with us."
    ),
    OnBoardScreenItems(
      "Your Bookish Soulmate Awaits",
      R.drawable.onboard_two,
      "Let us be your guide to the perfect read. Discover books tailored to your tastes for a truly rewarding experience."
    ),
    OnBoardScreenItems(
      "Start Your Adventure",
      R.drawable.onboard_three,
      "Ready to embark on a quest for inspiration and knowledge? Your adventure begins now. Let's go!"
    )
  )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(navController: NavHostController) {
  val authViewModel: AuthViewModel = viewModel()
  val firebaseUser by authViewModel.firebaseUser.observeAsState()
  LaunchedEffect(firebaseUser) {
    if (firebaseUser == null) {
      navController.navigate("on_board_screen") {
        popUpTo(navController.graph.startDestinationId)
        launchSingleTop = true
      }
    } else {
      navController.navigate("home_screen") {
        popUpTo(navController.graph.startDestinationId)
        launchSingleTop = true
      }
    }
  }
  val pagerState = rememberPagerState()
  val list = getList()
  val scope = rememberCoroutineScope()
  Column(modifier = Modifier.fillMaxSize()) {
    Text(
      text = "Skip",
      modifier =
        Modifier.padding(20.dp).clickable(
          indication = null,
          interactionSource = remember { MutableInteractionSource() }
        ) {
          navController.navigate("login")
        },
      fontSize = 16.sp,
      fontWeight = FontWeight.Medium,
      fontFamily = RobotoFamily
    )
    Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
      HorizontalPager(
        state = pagerState,
        verticalAlignment = Alignment.CenterVertically,
        count = list.size
      ) { currentPage ->
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = CenterHorizontally) {
          AsyncImage(
            model = list[currentPage].image,
            contentDescription = null,
            modifier = Modifier.height(330.dp).width(330.dp)
          )
          Text(
            text = list[currentPage].title,
            color = Color.Black,
            fontSize = 24.sp,
            fontFamily = RobotoFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 12.dp).width(300.dp)
          )
          Text(
            text = list[currentPage].description,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontFamily = RobotoFamily,
            modifier = Modifier.padding(top = 20.dp).width(300.dp).align(CenterHorizontally)
          )
          HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier.padding(top = 20.dp),
            activeColor = MainColor
          )
          Column(
            modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
            horizontalAlignment = CenterHorizontally
          ) {
            Button(
              onClick = {
                if (pagerState.currentPage < list.size - 1) {
                  scope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
                } else if (pagerState.currentPage == 2) {
                  navController.popBackStack()
                  navController.navigate("login")
                }
              },
              colors = ButtonDefaults.buttonColors(MainColor),
              shape = RoundedCornerShape(12.dp),
              modifier = Modifier.size(327.dp, 55.dp).align(Alignment.CenterHorizontally),
            ) {
              Text(
                text = "Get Started",
                color = Color.White,
                fontFamily = RobotoFamily,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
              )
            }
            Text(
              text = "Sign in",
              modifier =
                Modifier.padding(top = 20.dp).clickable(
                  indication = null,
                  interactionSource = remember { MutableInteractionSource() }
                ) {
                  navController.popBackStack()
                  navController.navigate("login")
                },
              fontWeight = FontWeight.Bold,
              color = MainColor,
              fontFamily = RobotoFamily,
            )
          }
        }
      }
    }
  }
}
