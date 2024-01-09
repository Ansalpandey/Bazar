package com.organisation.bazar.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.organisation.bazar.R
import com.organisation.bazar.ui.theme.MainColor
import com.organisation.bazar.ui.theme.RobotoFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
  var passwordVisible by remember { mutableStateOf(false) }
  Column {
    Row(modifier = Modifier.padding(20.dp)) {
      Icon(
        imageVector = Icons.Default.ArrowBack,
        contentDescription = "back button",
        tint = Color.Black,
        modifier =
          Modifier.size(32.dp).clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
          ) {
            navController.popBackStack()
            navController.navigate("on_board_screen")
          }
      )
    }
    Column(modifier = Modifier.fillMaxWidth()) {
      Text(
        text = "Welcome Back 👋",
        fontSize = 24.sp,
        color = Color.Black,
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 30.dp)
      )
      Text(
        text = "Login to your account",
        color = Color.Gray,
        fontSize = 16.sp,
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(start = 30.dp, top = 10.dp)
      )
    }

    Column(modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp, top = 30.dp)) {
      val email = remember { mutableStateOf("") }
      val password = remember { mutableStateOf("") }
      Text(
        text = "Email",
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
      )
      TextField(
        modifier =
          Modifier.fillMaxWidth()
            .padding(top = 8.dp)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp)),
        value = email.value,
        onValueChange = { email.value = it },
        textStyle =
          TextStyle(
            color = Color.Black,
            fontFamily = RobotoFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
          ),
        placeholder = {
          Text(
            text = "Your Email",
            fontFamily = RobotoFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.Gray
          )
        },
        shape = RoundedCornerShape(8.dp),
        colors =
          TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = MainColor,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color.White
          ),
        maxLines = 1,
        singleLine = true
      )
      Text(
        modifier = Modifier.padding(top = 10.dp),
        text = "Password",
        fontSize = 14.sp,
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Bold,
        color = Color.Black
      )

      TextField(
        modifier =
          Modifier.fillMaxWidth()
            .padding(top = 5.dp)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp)),
        value = password.value,
        onValueChange = { password.value = it },
        textStyle =
          TextStyle(
            color = Color.Black,
            fontFamily = RobotoFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
          ),
        placeholder = {
          Text(
            text = "Your Password",
            fontFamily = RobotoFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.Gray
          )
        },
        shape = RoundedCornerShape(8.dp),
        colors =
          TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = MainColor,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color.White
          ),
        maxLines = 1,
        singleLine = true,
        visualTransformation =
          if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
          val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

          // Localized description for accessibility services
          val description = if (passwordVisible) "Hide password" else "Show password"

          // Toggle button to hide or display password
          IconButton(onClick = { passwordVisible = !passwordVisible }) {
            Icon(imageVector = image, description)
          }
        }
      )
      Text(
        text = "Forgot Password?",
        modifier = Modifier.padding(top = 10.dp).clickable {},
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        fontFamily = RobotoFamily,
        color = MainColor
      )
      Spacer(modifier = Modifier.height(40.dp))
      Button(
        modifier = Modifier.fillMaxWidth().height(55.dp).padding(),
        colors = ButtonDefaults.buttonColors(MainColor),
        onClick = { /*TODO*/}
      ) {
        Text(
          text = "Login",
          fontSize = 16.sp,
          fontWeight = FontWeight.Bold,
          fontFamily = RobotoFamily,
          color = Color.White
        )
      }
      Row(modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 10.dp)) {
        Text(
          text = "Don’t have account? ",
          fontFamily = RobotoFamily,
          fontSize = 16.sp,
          fontWeight = FontWeight.Normal,
          color = Color.Gray
        )
        Text(
          text = "Sign Up ",
          textAlign = TextAlign.Center,
          modifier =
            Modifier.clickable(
              indication = null,
              interactionSource = remember { MutableInteractionSource() }
            ) {
              navController.navigate("sign_up")
            },
          fontFamily = RobotoFamily,
          fontWeight = FontWeight.Normal,
          color = MainColor,
          fontSize = 16.sp
        )
      }
    }
    Row(modifier = Modifier.padding(top = 20.dp)) {
      Divider(
        modifier = Modifier.fillMaxWidth(0.44f).padding(top = 10.dp, end = 5.dp).height(1.dp),
        color = Color.LightGray
      )
      Text(
        text = "Or with",
        fontSize = 14.sp,
        fontFamily = RobotoFamily,
        color = Color.Gray,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center
      )
      Divider(
        modifier = Modifier.fillMaxWidth(1f).padding(top = 10.dp, start = 5.dp).height(1.dp),
        color = Color.LightGray
      )
    }
    Column(modifier = Modifier.padding(top = 20.dp)) {
      OutlinedButton(
        modifier = Modifier.fillMaxWidth().height(55.dp).padding(start = 30.dp, end = 30.dp),
        onClick = { /*TODO*/},
        border = BorderStroke(1.dp, Color.LightGray),
        shape = RoundedCornerShape(40.dp)
      ) {
        Image(
          modifier = Modifier.size(32.dp).padding(end = 5.dp),
          painter = painterResource(id = R.drawable.google_app),
          contentDescription = "google"
        )
        Text(
          text = "Sign in with Google",
          fontFamily = RobotoFamily,
          fontWeight = FontWeight.Normal,
          color = Color.Black,
          fontSize = 14.sp,
          textAlign = TextAlign.Center
        )
      }
      Spacer(modifier = Modifier.height(10.dp))
      OutlinedButton(
        modifier = Modifier.fillMaxWidth().height(55.dp).padding(start = 30.dp, end = 30.dp),
        onClick = { /*TODO*/},
        border = BorderStroke(1.dp, Color.LightGray),
        shape = RoundedCornerShape(40.dp)
      ) {
        Image(
          modifier = Modifier.size(32.dp).padding(end = 5.dp),
          painter = painterResource(id = R.drawable.apple_logo),
          contentDescription = "google"
        )
        Text(
          text = "Sign in with Apple",
          fontFamily = RobotoFamily,
          fontWeight = FontWeight.Normal,
          color = Color.Black,
          fontSize = 14.sp,
          textAlign = TextAlign.Center
        )
      }
    }
  }
}

// @Preview(showBackground = true, showSystemUi = true)
// @Composable
// fun LoginScreenPreview() {
//  LoginScreen()
// }
