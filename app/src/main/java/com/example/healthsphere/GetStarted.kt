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

        val getstarted: TextView = findViewById(R.id.getstarted)

        var backToInfo: TextView = findViewById(R.id.info)
        backToInfo.setOnClickListener{
            val infoIntent: Intent = Intent(this, MainSlide::class.java)
            startActivity(infoIntent)
        }
        getstarted.setOnClickListener {
            val intent: Intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }
//        private void newactivity(){
//
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}