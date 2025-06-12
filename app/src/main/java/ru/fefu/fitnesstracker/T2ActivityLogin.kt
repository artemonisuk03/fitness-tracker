package ru.fefu.fitnesstracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class T2ActivityLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.t2_activity_login)
        val backarr: Button = findViewById(R.id.imageBackarr)

        backarr.setOnClickListener {
            val intent = Intent(this, T2ActivityMain::class.java)
            startActivity(intent)
        }

        val registerButton: Button = findViewById(R.id.registerButton)

        registerButton.setOnClickListener {
            val intent = Intent(this, T3ActivityEmptystate::class.java)
            startActivity(intent)
        }
    }
}