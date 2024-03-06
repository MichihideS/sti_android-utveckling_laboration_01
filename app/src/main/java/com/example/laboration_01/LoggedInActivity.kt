package com.example.laboration_01

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

        val tvLoggedInWelcome = binding.tvLoggedInWelcome
        val tvGachaResults = binding.tvGachaResults
        val btnDraw = binding.btnDraw

        // Welcomes the user with the username used to log in
        tvLoggedInWelcome.text = intent.getStringExtra("welcome")

        btnDraw.setOnClickListener {
            tvGachaResults.text = gacha()
            tvGachaResults.visibility = View.VISIBLE

        }
    }

    private fun gacha(): String {
        var threeStar = 0
        var fourStar = 0
        var fiveStar = 0

        for (i in 1..10) {
            val randomNumber = (1..1000).random()
            when (randomNumber) {
                in 1..6 -> fiveStar++
                in 7..58 -> fourStar++
                else -> threeStar++
            }
        }

        return("Here are your draw results!\nNumber of 3* pulls: $threeStar\nNumber of 4* pulls:" +
                " $fourStar\nNumber of 5* pulls: $fiveStar\nBetter luck next time!")
    }
}