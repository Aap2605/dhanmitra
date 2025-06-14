package com.dhanmitra

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val userNameText = findViewById<TextView>(R.id.userNameText)
        val helpSupportButton = findViewById<Button>(R.id.helpSupportButton)
        val profileImage = findViewById<ImageView>(R.id.profileImage)

        val userName = intent.getStringExtra("user_name") ?: "User"
        userNameText.text = "Welcome, $userName"

        helpSupportButton.setOnClickListener {
            Toast.makeText(this, "Help/Support coming soon", Toast.LENGTH_SHORT).show()
        }

        profileImage.setOnClickListener {
            Toast.makeText(this, "Profile feature coming soon", Toast.LENGTH_SHORT).show()
        }
    }
}
