package com.example.healthsphere

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class ResetPassword : BazeActivity() {
    private lateinit var et_email: TextInputEditText
    private lateinit var resetPass: TextView
    private lateinit var backbtn: LinearLayout
    private lateinit var toolbarforgotpassword: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.reset_password)
        et_email = findViewById(R.id.et_emailAdress)
        resetPass = findViewById(R.id.resetPass)
        backbtn = findViewById(R.id.backbtn)
        setupActionBar()

        backbtn.setOnClickListener{
            val loginActivity: Intent = Intent(this, SignIn::class.java)
            startActivity(loginActivity)
        }
        resetPass.setOnClickListener {
            et_email = findViewById(R.id.et_emailAdress)
            val email = et_email.text.toString().trim()
            if(email.isEmpty()){
                showErrorSnackBar(resources.getString(R.string.email_error), true)

            }else{
                showProgressDialog(resources.getString(R.string.please_wait))
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        hideProgressDialog()
                        if(task.isSuccessful){
                            Toast.makeText(this, resources.getString(R.string.email_sent), Toast.LENGTH_LONG
                            ).show()
                            //return back to login page
                            val backToLoginIntent = Intent(this,SignIn::class.java)
                            startActivity(backToLoginIntent)
                            finish()
                        }else{
                            showErrorSnackBar(task.exception!!.message.toString(), true)
                        }
                    }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun setupActionBar() {
        toolbarforgotpassword = findViewById(R.id.toolbar_forgot_password)
//            toolbar_register_activity = findViewById(R.id.toolbar_reg_activity)
        setSupportActionBar(toolbarforgotpassword)
        val actionBar = supportActionBar
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.arrow_back)
        }
        toolbarforgotpassword.setNavigationOnClickListener {
//            onBackPressedDispatcher.onBackPressed()
            val backintent = Intent(this, SignIn::class.java)
            startActivity(backintent)
        }
    }
}