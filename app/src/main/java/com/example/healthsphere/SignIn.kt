package com.example.healthsphere

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        val directtoSignUp: TextView = findViewById(R.id.direct_to_signUp)
        val underlineText: TextView = findViewById(R.id.forgotPassword)
        val goBack: LinearLayout = findViewById(R.id.backbtn)
        val sign_up: TextView = findViewById(R.id.sign_up)
        val mstring = "Forgot Password?"
        val mSpannableString = SpannableString(mstring)
        mSpannableString.setSpan(UnderlineSpan(), 0, mSpannableString.length, 0)
        // Displaying this spannable
        // string in TextView
        underlineText.text = mSpannableString
        directtoSignUp.setOnClickListener {
            val intent : Intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        goBack.setOnClickListener{
            var gobackIntent : Intent= Intent( this, GetStarted::class.java)
            startActivity(gobackIntent)
        }
        sign_up.setOnClickListener{
            val directHomebtn: Intent =Intent( this, MainActivity::class.java)
            startActivity(directHomebtn)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}