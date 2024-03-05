package com.example.laboration_01

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.laboration_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnSignIn = binding.btnSignIn
        val btnAbout = binding.btnAbout

        btnSignIn.setOnClickListener {
            val myIntent = Intent(this, SignInActivity::class.java)
            startActivity(myIntent)
        }

        btnAbout.setOnClickListener {
            val myIntent = Intent(this, AboutActivity::class.java)
            startActivity(myIntent)
        }

    }
}