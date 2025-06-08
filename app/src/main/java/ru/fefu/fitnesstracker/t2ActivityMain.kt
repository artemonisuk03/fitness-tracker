package ru.fefu.fitnesstracker

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class t2ActivityMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.t1_activity_main)
        val registerButton: Button = findViewById(R.id.registerButton)
        val loginText: TextView = findViewById(R.id.accountTextView)

        registerButton.setOnClickListener {
            val intent = Intent(this, t2ActivityRegistration::class.java)
            startActivity(intent)
        }

        loginText.setOnClickListener {
            val intent = Intent(this, t2ActivityLogin::class.java)
            startActivity(intent)
        }
    }
}