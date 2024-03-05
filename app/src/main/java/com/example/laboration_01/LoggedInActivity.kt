package com.example.laboration_01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.laboration_01.databinding.ActivityLoggedInBinding

class LoggedInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoggedInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoggedInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvLoggedInWelcome = binding.tvLoggedInWelcome

        tvLoggedInWelcome.text = intent.getStringExtra("welcome")

    }
}