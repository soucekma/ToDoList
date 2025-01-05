package com.example.todolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.widget.Toolbar
import com.example.todolist.data.TaskDatabase

class MainActivity : AppCompatActivity() {

    val database: TaskDatabase by lazy { TaskDatabase.getDatabase(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Enable back button on the toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Handle back button in the toolbar
        toolbar.setNavigationOnClickListener {
            onBackPressed() // Navigate back when the back arrow is clicked
        }

        // Handle window insets for fragments
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.nav_host_fragment)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
