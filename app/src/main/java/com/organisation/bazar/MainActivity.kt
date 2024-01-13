package com.organisation.bazar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.organisation.bazar.screens.MainHome
import com.organisation.bazar.ui.theme.BazarTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
  private val viewModel: SplashViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // add it before setContent
    installSplashScreen().apply { setKeepOnScreenCondition { viewModel.loading.value } }
    setContent {
      BazarTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = Color.White) { MainHome() }
      }
    }
  }
}

class SplashViewModel : ViewModel() {
  private val _loading = MutableStateFlow(true)
  val loading = _loading.asStateFlow()

  init {
    viewModelScope.launch {
      // run background task here
      delay(2000)
      _loading.value = false
    }
  }
}
