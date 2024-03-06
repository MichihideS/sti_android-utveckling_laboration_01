package com.example.laboration_01

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.laboration_01.databinding.ActivityAboutBinding
import com.example.laboration_01.databinding.ActivityLoggedInBinding

class LoggedInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoggedInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoggedInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Components
        val tvLoggedInWelcome = binding.tvLoggedInWelcome
        val tvGachaResults = binding.tvGachaResults
        val btnDraw = binding.btnDraw
        val btnLogout = binding.btnLogout
        val gacha = Gacha()

        // Welcomes the user with the username used to log in
        tvLoggedInWelcome.text = intent.getStringExtra("welcome")

        // Button that calls the gacha function from Gacha class and turns the textview visible
        btnDraw.setOnClickListener {
            tvGachaResults.text = gacha.randomNumber()
            tvGachaResults.visibility = View.VISIBLE
        }

        // Button that returns the user to the main activity
        btnLogout.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }
    }
}
