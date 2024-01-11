package com.organisation.bazar.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel : ViewModel() {
  private val auth = FirebaseAuth.getInstance()
  private val dataBase = FirebaseDatabase.getInstance()

  val userRef = dataBase.getReference("users")

  private val _firebaseUser = MutableLiveData<FirebaseUser>()
  val firebaseUser: LiveData<FirebaseUser> = _firebaseUser

  private val _error = MutableLiveData<String>()
  val error: LiveData<String> = _error

  init {
    _firebaseUser.value = auth.currentUser
  }

  fun login(
    email: String,
    password: String,
    navController: NavHostController,
    callback: (Boolean) -> Unit
  ) {
    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
      if (it.isSuccessful) {
        callback(true)
      } else {
        callback(false)
      }
    }
  }

  fun register(email: String, password: String, name: String) {
    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { registrationTask ->
      if (registrationTask.isSuccessful) {
        val user = auth.currentUser
        _firebaseUser.postValue(user)

        // Store user information in the database
        user?.let {
          val userId = it.uid
          val userMap = hashMapOf(
            "uid" to userId,
            "email" to email,
            "name" to name
          )

          userRef.child(userId).setValue(userMap)
        }
      } else {
        _error.postValue("Something went wrong...")
      }
    }
  }

  fun logout() {
    auth.signOut()
  }
}

