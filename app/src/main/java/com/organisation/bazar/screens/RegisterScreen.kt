package com.organisation.bazar.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.organisation.bazar.ui.theme.MainColor
import com.organisation.bazar.ui.theme.RobotoFamily
import com.organisation.bazar.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController) {
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
            navController.navigate("login")
          }
      )
    }
    Column(modifier = Modifier.fillMaxWidth()) {
      Text(
        text = "Sign Up",
        fontSize = 24.sp,
        color = Color.Black,
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 30.dp)
      )
      Text(
        text = "Create account and choose favorite menu",
        color = Color.Gray,
        fontSize = 16.sp,
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(start = 30.dp, top = 10.dp)
      )
    }

    Column(modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp, top = 20.dp)) {
      val context = LocalContext.current
      var email by remember { mutableStateOf("") }
      var password by remember { mutableStateOf("") }
      var name by remember { mutableStateOf("") }

      val authViewModel: AuthViewModel = viewModel()
      val firebaseUser by authViewModel.firebaseUser.observeAsState(null)
      Text(
        text = "Name",
        fontFamily = RobotoFamily,
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
      )
      TextField(
        modifier =
          Modifier.fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp)),
        value = name,
        onValueChange = { name = it },
        textStyle =
          TextStyle(
            color = Color.Black,
            fontFamily = RobotoFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
          ),
        placeholder = {
          Text(
            text = "Your name",
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
        text = "Email",
        color = Color.Black,
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
      )
      TextField(
        modifier =
          Modifier.fillMaxWidth()
            .padding(top = 10.dp)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp)),
        value = email,
        onValueChange = { email = it },
        textStyle =
          TextStyle(
            color = Color.Black,
            fontFamily = RobotoFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
          ),
        placeholder = {
          Text(
            text = "Your email",
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
            .padding(top = 10.dp)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp)),
        value = password,
        onValueChange = { password = it },
        textStyle =
          TextStyle(
            color = Color.Black,
            fontFamily = RobotoFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
          ),
        placeholder = {
          Text(
            text = "Your password",
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
      Spacer(modifier = Modifier.height(20.dp))
      Button(
        modifier = Modifier.fillMaxWidth().height(55.dp).padding(),
        colors = ButtonDefaults.buttonColors(MainColor),
        onClick = {
          if (email.isEmpty() || password.isEmpty() || name.isEmpty()) {
            Toast.makeText(context, "Enter all the details.", Toast.LENGTH_LONG).show()
          } else {
            authViewModel.register(email, password, name)
            Toast.makeText(context, "Registered", Toast.LENGTH_LONG).show()
          }
        }
      ) {
        Text(
          text = "Register",
          fontSize = 16.sp,
          fontWeight = FontWeight.Bold,
          fontFamily = RobotoFamily,
          color = Color.White
        )
      }
      Row(modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 10.dp)) {
        Text(
          text = "Have an account? ",
          fontFamily = RobotoFamily,
          fontSize = 16.sp,
          fontWeight = FontWeight.Normal,
          color = Color.Gray
        )
        Text(
          text = "Sign In",
          textAlign = TextAlign.Center,
          modifier =
            Modifier.clickable(
              indication = null,
              interactionSource = remember { MutableInteractionSource() }
            ) {
              navController.navigate("login")
            },
          fontFamily = RobotoFamily,
          fontWeight = FontWeight.Normal,
          color = MainColor,
          fontSize = 16.sp
        )
      }
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 40.dp).height(100.dp).width(350.dp)
      ) {
        Text(
          text = "By clicking Register, you agree to our",
          textAlign = TextAlign.Center,
          fontSize = 14.sp,
          fontWeight = FontWeight.Medium,
          fontFamily = RobotoFamily,
          color = Color.Gray
        )
        Text(
          text = "Terms and Data Policy.",
          textAlign = TextAlign.Center,
          fontSize = 14.sp,
          fontWeight = FontWeight.Medium,
          fontFamily = RobotoFamily,
          color = MainColor
        )
      }
    }
  }
}
