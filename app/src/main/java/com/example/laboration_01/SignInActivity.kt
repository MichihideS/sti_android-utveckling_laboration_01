package com.example.laboration_01

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.laboration_01.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnLogIn = binding.btnRegisterOk
        val btnRegister = binding.btnRegister
        // Predefined list of users able to sign in
        val users = arrayListOf("michan", "Michan", "test")
        val importArray = intent.getStringArrayListExtra("array")
        val userTest = importArray.toString()

        // Button that navigates you to LoggedInActivity if the input text matches the arraylist
        btnLogIn.setOnClickListener {
            println(userTest)
            val username = binding.etUsername.text.toString()

            // Loops and checks if the input matches any string in the arraylist
            for (item in users)
                if (username == item) {
                    val myIntent = Intent(this, LoggedInActivity::class.java).apply {
                        putExtra("welcome", "Welcome $username")
                    }
                    startActivity(myIntent)
                }
        }

        btnRegister.setOnClickListener {
            val myIntent = Intent(this, RegisterActivity::class.java)
            startActivity(myIntent)
        }

    }
}
