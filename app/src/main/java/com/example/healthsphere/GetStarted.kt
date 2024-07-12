package com.example.healthsphere

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GetStarted : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_get_started)
        var nextlogin: TextView = findViewById(R.id.nextLogin)
        var getstarted: TextView = findViewById(R.id.getstarted)
//        nextlogin.setOnClickListener {
//            val loginstart: Intent=Intent(this, SignIn::class.java)
//            startActivity(loginstart)
//        }
        getstarted.setOnClickListener {
            val intent: Intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}