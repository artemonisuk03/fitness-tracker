package ru.fefu.fitnesstracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class t2ActivityRegistration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.t2_activity_registration)
        val backArr: Button = findViewById(R.id.imageBackarr)

        backArr.setOnClickListener {
            val intent = Intent(this, t2ActivityMain::class.java)
            startActivity(intent)
        }

        val registerButton: Button = findViewById(R.id.registerButton)

        registerButton.setOnClickListener {
            val intent = Intent(this, t3ActivityEmptystate::class.java)
            startActivity(intent)
        }
    }
}