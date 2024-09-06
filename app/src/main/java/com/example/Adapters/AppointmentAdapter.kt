package com.example.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.models.Appointment
import com.example.healthsphere.R

class AppointmentAdapter(private val context: Context, private val appointments: List<Appointment>) :
        ArrayAdapter<Appointment>(context, 0, appointments) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_appointment, parent, false)
        val appointment = getItem(position)

//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        val appointment = getItem(position)
//        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_appointment, parent, false)

        val tvDate = view.findViewById<TextView>(R.id.tvDate)
        val tvTime = view.findViewById<TextView>(R.id.tvTime)
        val tvFees = view.findViewById<TextView>(R.id.tvFees)
        val Email = view.findViewById<TextView>(R.id.Email)
        val tvName = view.findViewById<TextView>(R.id.tvAppointmentName)
        val tvStatus = view.findViewById<TextView>(R.id.tvAppointmentStatus)
        //val username = view.findViewById<TextView>(R.id.tvFees)
        Email.text = appointment?.userEmail
        tvDate.text = appointment?.date
        tvTime.text = appointment?.time
        tvFees.text = "Fees: Ksh ${appointment?.fees}"

        tvName.text = appointment?.name
        val isCompleted = appointment?.completed ?: false
        if (isCompleted) {
            tvStatus.text = "Completed"
            tvStatus.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_red_dark))
        } else {
            tvStatus.text = "Active"
            tvStatus.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_green_dark))
        }

        return view
    }
}
