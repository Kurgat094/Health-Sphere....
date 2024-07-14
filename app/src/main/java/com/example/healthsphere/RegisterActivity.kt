package com.example.healthsphere

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        val sign_up : TextView = findViewById(R.id.sign_up)
        sign_up.setOnClickListener {
            var signIntent: Intent = Intent(this, OTP_Activity::class.java)
            startActivity(signIntent)
        }
        val backbtn: LinearLayout = findViewById(R.id.backbtn)
        backbtn.setOnClickListener{
            var intent : Intent = Intent(this, GetStarted::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}