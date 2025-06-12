package ru.fefu.fitnesstracker

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class T2ActivityMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.t2_activity_main)
        val registerButton: Button = findViewById(R.id.registerButton)
        val loginText: TextView = findViewById(R.id.accExistsText)

        registerButton.setOnClickListener {
            val intent = Intent(this, T2ActivityRegistration::class.java)
            startActivity(intent)
        }

        loginText.setOnClickListener {
            val intent = Intent(this, T2ActivityLogin::class.java)
            startActivity(intent)
        }
    }
}