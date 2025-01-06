package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat // Import this

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Access the root layout
        val rootLayout = findViewById<LinearLayout>(R.id.rootLayout)

        // Determine light/dark mode and set the background
        val isDarkMode = when (resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK) {
            android.content.res.Configuration.UI_MODE_NIGHT_YES -> true
            android.content.res.Configuration.UI_MODE_NIGHT_NO -> false
            else -> false
        }

        // Set background color using ContextCompat
        val backgroundColor = if (isDarkMode) {
            ContextCompat.getColor(this, R.color.darkgray)
        } else {
            ContextCompat.getColor(this, R.color.white)
        }
        rootLayout.setBackgroundColor(backgroundColor)

        // Navigate to MainActivity after a delay
        val splashScreenDuration = 2000L
        rootLayout.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, splashScreenDuration)
    }
}
