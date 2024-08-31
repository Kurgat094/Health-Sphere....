package com.example.healthsphere

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.UnderlineSpan
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.healthsphere.databinding.ActivityRegisterBinding
import com.example.healthsphere.databinding.ActivitySignInBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class SignIn :  BazeActivity() {
    private lateinit var mbinding:ActivitySignInBinding
    private lateinit var et_emailAdress: TextInputEditText
    private lateinit var et_password: TextInputEditText
    private lateinit var logIn: TextView
    private lateinit var forgotPassword: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
//        forgotPassword = findViewById(R.id.forgotPassword)
        mbinding = ActivitySignInBinding.inflate(LayoutInflater.from(this))
        setContentView(mbinding.root)
        et_emailAdress = findViewById(R.id.et_emailAdress)
        et_password = findViewById(R.id.et_password)
        logIn = findViewById(R.id.sign_up)
        val directtoSignUp: TextView = findViewById(R.id.direct_to_signUp)
        val pwdbtn: TextView = findViewById(R.id.pwd)
        val goBack: LinearLayout = findViewById(R.id.backbtn)
        directtoSignUp.setOnClickListener {
            val intent : Intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        pwdbtn.setOnClickListener {
            val intent : Intent = Intent(this, ResetPassActivity::class.java)
            startActivity(intent)
        }

        goBack.setOnClickListener{
            val gobackIntent : Intent= Intent( this, MainSlide::class.java)
            startActivity(gobackIntent)
            finish()
        }
        logIn.setOnClickListener{
            loginRegisteredUser()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun valideteDetails(): Boolean{
        return when {
            TextUtils.isEmpty(et_emailAdress.text.toString().trim()) ->{
                showErrorSnackBar(resources.getString(R.string.email_error), true)
                false
            }
            TextUtils.isEmpty(et_password.text.toString().trim()) -> {
                showErrorSnackBar(resources.getString(R.string.errorPass), true)
                false
            }
            else ->{
                true
            }
        }
    }
    private fun loginRegisteredUser(){
        if(valideteDetails()){
            showProgressDialog(resources.getString(R.string.please_wait))
            val email = et_emailAdress.text.toString().trim()
            val password = et_password.text.toString().trim()
            //login User Using Firebase
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    hideProgressDialog()
                    if(task.isSuccessful){
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }else{
                        hideProgressDialog()
                        showErrorSnackBar(task.exception!!.message.toString(), true)
                    }
                }
        }
    }
}