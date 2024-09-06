package com.example.healthsphere

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

import com.example.models.Doctor
import com.google.firebase.firestore.FirebaseFirestore

class FindDoctors : BazeActivity() {
    private lateinit var backbtn: LinearLayout
    private lateinit var cardFindFamDoc: CardView
    private lateinit var cardDentist: CardView
    private lateinit var cardSergion: CardView
    private lateinit var cardOptician: CardView
    private lateinit var Dietician: CardView
    private lateinit var Cardphamacy: CardView

    private val db = FirebaseFirestore.getInstance()

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
            fetchDoctors("Pharmacy")
        }

        cardSergion.setOnClickListener {
            fetchDoctors("Surgeon")
        }

        cardOptician.setOnClickListener {
            fetchDoctors("Optician")
        }

        cardDentist.setOnClickListener {
            fetchDoctors("Dentist")
        }

        cardFindFamDoc.setOnClickListener {
            fetchDoctors("Family Physician")
        }
    }

    private fun fetchDoctors(category: String) {
        showProgressDialog(resources.getString(R.string.please_wait))
        db.collection("doctors")
            .whereEqualTo("category", category)
            .get()
            .addOnSuccessListener { result ->
                val doctorDetails = result.map { document ->
                    val doctor = document.toObject(Doctor::class.java)
                    arrayOf(
                        doctor.name,
                        doctor.address,
                        doctor.experience,
                        doctor.email,
                        doctor.fees
//                        "Doctor Name: ${doctor.name}",
//                        "Hospital Address: ${doctor.address}",
//                        "Exp: ${doctor.experience}",
//                        " ${doctor.email}",
//                        "Charges: ${doctor.fees}"
                    )
                }.toTypedArray()

                val intent = Intent(this, DoctorDetails::class.java)
                intent.putExtra("title", category)
                intent.putExtra("doctorDetails", doctorDetails)
                startActivity(intent)
            }
            .addOnFailureListener { exception ->
                // Handle the error
                Toast.makeText(this, "error fetching Doctor data ${exception}", Toast.LENGTH_SHORT)
                    .show()
                hideProgressDialog()
            }
    }
}
