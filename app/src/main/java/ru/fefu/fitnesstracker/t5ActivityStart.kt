package ru.fefu.fitnesstracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class t5ActivityStart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.t5_activity_start)

        supportFragmentManager.beginTransaction()
                .replace(R.id.activitySelector, t5FragmentStart1.newInstance())
            .commit()
    }
}