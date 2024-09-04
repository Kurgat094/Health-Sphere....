package com.example.healthsphere

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fragments.HomeFragment

class FindDoctors : AppCompatActivity() {
    private lateinit var backbtn: LinearLayout
    private lateinit var cardFindFamDoc: CardView
    private lateinit var cardDentist: CardView
    private lateinit var cardSergion : CardView
    private lateinit var cardOptician : CardView
    private lateinit var Dietician : CardView
    private lateinit var Cardphamacy: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_find_doctors)
        backbtn = findViewById(R.id.backbtn)
        cardFindFamDoc = findViewById(R.id.cardFindFamDoc)
        Cardphamacy = findViewById(R.id.Cardphamacy)
        Dietician = findViewById(R.id.Dietician)
        cardOptician = findViewById(R.id.cardOptician)
        cardSergion = findViewById(R.id.cardSergion)
        cardDentist = findViewById(R.id.cardDentist)

        backbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        Cardphamacy.setOnClickListener {
            val pharmacyIntent = Intent(this, DoctorDetails::class.java)
            pharmacyIntent.putExtra("title", "Pharmacy")
            startActivity(pharmacyIntent)
        }

        cardSergion.setOnClickListener {
            val surgeonIntent = Intent(this, DoctorDetails::class.java)
            surgeonIntent.putExtra("title", "Surgeon")
            startActivity(surgeonIntent)
        }



        Dietician.setOnClickListener{
            val activityintent = Intent(this, DoctorDetails::class.java)
            activityintent.putExtra("title", "Dietician")
            startActivity(activityintent)
        }
        cardDentist.setOnClickListener{
            val dentistintent = Intent(this, DoctorDetails::class.java)
            dentistintent.putExtra("title", "Dentist specialist")
            startActivity(dentistintent)
        }
        cardFindFamDoc.setOnClickListener{
            val famdocintent = Intent(this, DoctorDetails::class.java)
            famdocintent.putExtra("title", "family physisian")
            startActivity(famdocintent)
        }
        cardOptician.setOnClickListener{
            val actityintent = Intent(this, DoctorDetails::class.java)
            actityintent.putExtra("title", "Opticle unit")
            startActivity(actityintent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}