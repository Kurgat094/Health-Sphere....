package com.example.healthsphere

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Adapters.AppointmentAdapter
import com.example.firestore.FirestoreClass
import com.example.models.Appointment
import com.example.utils.Constants

class DoctorDashboardActivity : AppCompatActivity() {
    private lateinit var tvTotalFees: TextView
    private lateinit var lvAppointments: ListView
    private lateinit var backbtn : LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_dashboard)

        tvTotalFees = findViewById(R.id.tvTotalFees)
        lvAppointments = findViewById(R.id.lvAppointments)
        backbtn = findViewById(R.id.backbtn)
        backbtn.setOnClickListener {
            val backint  = Intent(this, MainActivity::class.java)
            startActivity(backint)
        }

        val doctorName = getLoggedInDoctorName()
        FirestoreClass().getAppointmentsForDoctor(doctorName, { appointments ->
            setupAppointmentsList(appointments)
            calculateTotalFees(appointments)
        }, { e ->
            Toast.makeText(this, "Failed to load appointments: ${e.message}", Toast.LENGTH_SHORT).show()
        })
    }

    private fun getLoggedInDoctorName(): String {
        val sharedPreferences = getSharedPreferences(Constants.HEALTHAPP_PREFERENCES, MODE_PRIVATE)
        return sharedPreferences.getString(Constants.LOGGED_IN_USERNAME, "") ?: ""
    }

    private fun setupAppointmentsList(appointments: List<Appointment>) {
        val adapter = AppointmentAdapter(this, appointments)
        lvAppointments.adapter = adapter
    }

    private fun calculateTotalFees(appointments: List<Appointment>) {
        val totalFees = appointments.sumOf { it.fees.toDouble() }
        tvTotalFees.text = "Total Fees: Ksh $totalFees"
    }
}