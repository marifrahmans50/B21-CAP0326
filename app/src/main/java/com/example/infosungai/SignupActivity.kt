package com.example.infosungai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()
    }

    fun signUp(view: View){
        val email = editTextSignupEmail.text.toString()
        val password = editTextSignupPassword.text.toString()
        val passwordAgain = editTextSignupConfirmPassword.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty() && passwordAgain.isNotEmpty()){
            if(password == passwordAgain){
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Registration Successful", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this,ActivityHome::class.java)
                        startActivity(intent)
                        finish()
                    }
                }.addOnFailureListener { exception ->
                    Toast.makeText(this,exception.localizedMessage, Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this,"Please Enter Passwords Correctly", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this,"Please Fill In All Fields", Toast.LENGTH_LONG).show()
        }
    }
}