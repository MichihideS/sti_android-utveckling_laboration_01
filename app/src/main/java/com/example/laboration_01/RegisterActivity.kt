package com.example.laboration_01

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.laboration_01.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnRegister = binding.btnSignInLogin
        val btnBack = binding.btnBack
        val registeredUsers: ArrayList<String> = ArrayList()

        // Register button that goes through couple of checks before adding username to arraylist
        btnRegister.setOnClickListener {
            val registerName = binding.etUsername.text.toString()
            var checkName = false
            val builder = AlertDialog.Builder(this)

            // Checks if the user is already registered
            for (item in registeredUsers) {
                if (item == registerName) {
                    checkName = true
                }
            }

            // If user exists gets error message
            if (checkName) {
                builder.setMessage("$registerName is already registered!")
                builder.setTitle("Error!")
                builder.setCancelable(true)
                builder.setPositiveButton("Ok"){ dialog, _ -> dialog.cancel()}
                val alertDialog = builder.create()
                alertDialog.show()
            // If empty space gets error message
            } else if (registerName == "") {
                builder.setMessage("Please enter a valid name!")
                builder.setTitle("Error!")
                builder.setCancelable(true)
                builder.setPositiveButton("Ok"){ dialog, _ -> dialog.cancel()}
                val alertDialog = builder.create()
                alertDialog.show()
            // If none above, the user is created
            } else {
                registeredUsers.add(registerName)
                builder.setMessage("$registerName has been registered! Press back to continue login")
                builder.setTitle("Success!")
                builder.setCancelable(true)
                builder.setPositiveButton("Ok"){ dialog, _ -> dialog.cancel()}
                val alertDialog = builder.create()
                alertDialog.show()
            }
        }

        // Button that returns user to sign in activity and sends the data of the arraylist too
        btnBack.setOnClickListener {
            val myIntent = Intent(this, SignInActivity::class.java).apply {
                putExtra("array", registeredUsers)
            }
            startActivity(myIntent)
        }
    }
}