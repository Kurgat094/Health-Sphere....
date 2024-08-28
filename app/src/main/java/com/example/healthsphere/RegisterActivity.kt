package com.example.healthsphere

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : BazeActivity() {
    private lateinit var et_username : EditText
    private lateinit var et_phoneNo : EditText
    private lateinit var et_emailAdress: EditText
    private lateinit var et_password : EditText
    private lateinit var et_confirmPass: EditText
    private lateinit var cb_checkbox: CheckBox
    private lateinit var sign_up : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        sign_up = findViewById(R.id.sign_up)
        et_username = findViewById(R.id.et_username)
        et_phoneNo = findViewById(R.id.et_phoneNo)
        et_emailAdress = findViewById(R.id.et_emailAdress)
        et_password = findViewById(R.id.et_password)
        et_confirmPass = findViewById(R.id.et_confirmPass)
        cb_checkbox = findViewById(R.id.cb_checkbox)
        sign_up.setOnClickListener {
            var signIntent: Intent = Intent(this, OTP_Activity::class.java)
            startActivity(signIntent)
        }
        val backbtn: LinearLayout = findViewById(R.id.backbtn)
        backbtn.setOnClickListener{
            var intent : Intent = Intent(this, GetStarted::class.java)
            startActivity(intent)
        }
        sign_up.setOnClickListener{
            validateRegisterDetails()
//            Toast.makeText(, "", Toast.LENGTH_SHORT).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    // Helper function to validate password strength
    private fun isValidPassword(password: String): Boolean {
        val passwordPattern = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}\$")
        return passwordPattern.matches(password)
    }
    private fun validateRegisterDetails(): Boolean{
        val email = et_emailAdress.text.toString().trim()
        val password = et_password.text.toString().trim()
        val confirmPassword = et_confirmPass.text.toString().trim()
        return when {
            TextUtils.isEmpty(et_username.text.toString().trim()) -> {
                showErrorSnackBar(resources.getString(R.string.error_name), true)
                false
            }

            TextUtils.isEmpty(et_phoneNo.text.toString().trim()) -> {
                showErrorSnackBar(resources.getString(R.string.error_phoneNo), true)
                false
            }
            TextUtils.isEmpty(et_confirmPass.text.toString().trim()) -> {
                showErrorSnackBar(resources.getString(R.string.errorPassword), true)
                false
            }
            TextUtils.isEmpty(et_emailAdress.text.toString().trim()) -> {
                showErrorSnackBar(resources.getString(R.string.errorEmail), true)
                false
            }

            TextUtils.isEmpty(et_confirmPass.text.toString().trim()) -> {
                showErrorSnackBar(resources.getString(R.string.errorPassword), true)
                false
            }
            (et_password.text.toString().trim() != et_confirmPass.text.toString().trim()) ->{
                showErrorSnackBar("password should match", true)
                false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                showErrorSnackBar(resources.getString(R.string.errorInvalidEmail), true)
                false
            }
            !isValidPassword(password) -> {
                showErrorSnackBar(resources.getString(R.string.strongpass), true)
                false
            }

            !cb_checkbox.isChecked -> {
                showErrorSnackBar(resources.getString(R.string.check_terms),true)
                false
            }
            else -> {
//                showErrorSnackBar(resources.getString(R.string.sucessregistration), false)
                true
            }

        }
    }
    private fun registerUser(){

    }
}