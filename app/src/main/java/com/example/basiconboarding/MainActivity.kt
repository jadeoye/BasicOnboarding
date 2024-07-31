package com.example.basiconboarding

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loginFragment = LoginFragment()
        val learnMoreFragment = LearnMoreFragment()

        val loginFragmentLabel: TextView = findViewById(R.id.loginFragment)
        val learnMoreFragmentLabel: TextView = findViewById(R.id.learnMoreFragment)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, loginFragment)
            commit()
        }

        loginFragmentLabel.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, loginFragment)
                commit()
            }
        }

        learnMoreFragmentLabel.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, learnMoreFragment)
                commit()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_app_version -> {
                Toast.makeText(this, "App Version: 1.0.0", Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_build_number -> {
                Toast.makeText(this, "Build Number: A1C3N9", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}