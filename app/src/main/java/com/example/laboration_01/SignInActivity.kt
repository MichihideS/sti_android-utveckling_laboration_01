package com.example.laboration_01

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.laboration_01.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Components
        val btnLogIn = binding.btnSignInLogin
        val btnRegister = binding.btnRegister
        val btnBack = binding.btnBack
        val importArray = intent.getStringArrayListExtra("array")
        val builder = AlertDialog.Builder(this)

        // Button that navigates you to logged in activity if the input text matches the arraylist
        btnLogIn.setOnClickListener {
            val username = binding.etUsername.text.toString()

            /* Loops and checks if the input matches any string in the arraylist and checks
            ** if the list is empty or if you enter an empty string */
            if (importArray != null) {
                for (item in importArray)
                    when (username) {
                        item -> {
                            val myIntent = Intent(this, LoggedInActivity::class.java)
                                .apply {
                                putExtra("welcome", "Welcome $username")
                            }
                            startActivity(myIntent)
                        }
                        "" -> {
                            builder.setMessage("Please enter a valid name!")
                            builder.setTitle("Error!")
                            builder.setCancelable(true)
                            builder.setPositiveButton("Ok"){ dialog, _ -> dialog.cancel()}
                            val alertDialog = builder.create()
                            alertDialog.show()
                        }
                        else -> {
                            builder.setMessage("$username does not exist!")
                            builder.setTitle("Error!")
                            builder.setCancelable(true)
                            builder.setPositiveButton("Ok"){ dialog, _ -> dialog.cancel()}
                            val alertDialog = builder.create()
                            alertDialog.show()
                        }
                    }
            } else {
                builder.setMessage("No users have been registered")
                builder.setTitle("Error!")
                builder.setCancelable(true)
                builder.setPositiveButton("Ok"){ dialog, _ -> dialog.cancel()}
                val alertDialog = builder.create()
                alertDialog.show()
            }
        }

        // Button that takes you to the register activity
        btnRegister.setOnClickListener {
                val myIntent = Intent(this, RegisterActivity::class.java)
                startActivity(myIntent)
        }

        // Button that takes you back to the main activity
        btnBack.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }
    }
}
