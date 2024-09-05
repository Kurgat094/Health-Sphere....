package com.example.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.BaseAdapter
import com.example.healthsphere.R
import com.example.models.Appointment

class AppointmentAdapter(private val context: Context, private val appointments: List<Appointment>) : BaseAdapter() {

    override fun getCount(): Int = appointments.size

    override fun getItem(position: Int): Appointment = appointments[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.multilinestv2, parent, false)

        val appointment = getItem(position)

        // Populate the view with appointment data
        val tvPatientName = view.findViewById<TextView>(R.id.line1)
        val tvAppointmentTime = view.findViewById<TextView>(R.id.line3)
        val tvAppointmentDate = view.findViewById<TextView>(R.id.line4)
        val tvAppointmentFees = view.findViewById<TextView>(R.id.line5)

        tvPatientName.text = "Patient: ${appointment.patientName}"
        tvAppointmentTime.text = "Time: ${appointment.time}"
        tvAppointmentDate.text = "Date: ${appointment.date}"
        tvAppointmentFees.text = "Fees: Ksh ${appointment.fees}"

        return view
    }
}
