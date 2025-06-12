package ru.fefu.fitnesstracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class T5ActivityStart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.t5_activity_start)

        supportFragmentManager.beginTransaction()
                .replace(R.id.activitySelector, T5FragmentStart1.newInstance())
            .commit()
    }
}