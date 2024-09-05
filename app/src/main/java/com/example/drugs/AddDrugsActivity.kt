package com.example.drugs

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firestore.FirestoreClass
import com.example.healthsphere.R
import com.example.models.Doctor
import com.google.firebase.firestore.FirebaseFirestore

class AddDrugsActivity : AppCompatActivity() {
    private lateinit var etDoctorName: EditText
    private lateinit var etDoctorAddress: EditText
    private lateinit var etDoctorExperience: EditText
    private lateinit var etDoctorMobile: EditText
    private lateinit var etDoctorFees: EditText
    private lateinit var btnAddDoctor: Button
    private lateinit var spinnerCategory: Spinner


    private lateinit var etDrugName: EditText
    private lateinit var etDescription: EditText
    private lateinit var etPrice: EditText
    private lateinit var btnChooseImage: Button
    private lateinit var btnSubmit: Button
    private lateinit var firestoreClass: FirestoreClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_drugs)
        // Initialize FirestoreClass here
        firestoreClass = FirestoreClass()
        etDrugName = findViewById(R.id.etDrugName)
        etDescription = findViewById(R.id.etDescription)
        btnChooseImage = findViewById(R.id.btnChooseImage)
        btnSubmit = findViewById(R.id.btnSubmit)
        etPrice = findViewById(R.id.etPrice)
//add Doc
        spinnerCategory = findViewById(R.id.spinnerCategory)
        etDoctorName = findViewById(R.id.etDoctorName)
        etDoctorAddress = findViewById(R.id.etDoctorAddress)
        etDoctorExperience = findViewById(R.id.etDoctorExperience)
        etDoctorMobile = findViewById(R.id.etDoctorMobile)
        etDoctorFees = findViewById(R.id.etDoctorFees)
        btnAddDoctor = findViewById(R.id.btnAddDoctor)

        // Set up the Spinner with categories
        val categories = resources.getStringArray(R.array.doctor_categories)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory.adapter = adapter

        btnAddDoctor.setOnClickListener {
            addDoctorToFirestore()
        }

        btnSubmit.setOnClickListener {
            val drugName = etDrugName.text.toString()
            val price = etPrice.text.toString()
            val description = etDescription.text.toString()
            if (drugName.isNotEmpty() && price.isNotEmpty() && description.isNotEmpty()) {
                firestoreClass.addDrug(
                    drugName = drugName,
                    price = price,
                    description = description,
                    onSuccess = {

                        // Handle success (e.g., show a message or navigate to another activity)
                        Toast.makeText(this, "success drug added", Toast.LENGTH_SHORT).show()
                        etDrugName.text.clear()
                        etPrice.text.clear()
                        etDescription.text.clear()
                    },
                    onFailure = { e ->
                        // Handle failure (e.g., show an error message)
                        Toast.makeText(this, "Failed to add drug: ${e.message}", Toast.LENGTH_SHORT).show()
                    })
            }else{
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }
        btnAddDoctor.setOnClickListener {
            addDoctorToFirestore()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun addDoctorToFirestore() {

        // Get values from input fields
        val name = etDoctorName.text.toString().trim()
        val address = etDoctorAddress.text.toString().trim()
        val experience = etDoctorExperience.text.toString().trim()
        val email = etDoctorMobile.text.toString().trim()
        val fees = etDoctorFees.text.toString().trim()
        val category = spinnerCategory.selectedItem.toString()

        // Validate input
        if (name.isEmpty() || address.isEmpty() || experience.isEmpty() ||
            email.isEmpty() || fees.isEmpty() || category == "Select Category") {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }
        val doctor = Doctor(
            name = name,
            address = address,
            experience = experience,
            email = email,
            fees = fees,
            category = category
        )

        // Add doctor to Firestore
        val firestore = FirebaseFirestore.getInstance()
        firestore.collection("doctors")
            .add(doctor)
            .addOnSuccessListener {
                Toast.makeText(this, "Doctor added successfully!", Toast.LENGTH_SHORT).show()
                // Clear input fields
                clearFields()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Failed to add doctor: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun clearFields() {
        etDoctorName.text.clear()
        etDoctorAddress.text.clear()
        etDoctorExperience.text.clear()
        etDoctorMobile.text.clear()
        etDoctorFees.text.clear()
        spinnerCategory.setSelection(0)
    }
}
