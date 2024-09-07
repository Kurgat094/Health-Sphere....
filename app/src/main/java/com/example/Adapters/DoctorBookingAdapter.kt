package com.example.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.models.DoctorBooking
import com.example.healthsphere.R

class DoctorBookingAdapter(private val context: Context, private val items: List<DoctorBooking>) : BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): DoctorBooking = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.multilines, parent, false)
            viewHolder = ViewHolder(
                line1 = view.findViewById(R.id.line1),
                line2 = view.findViewById(R.id.line2),
                line3 = view.findViewById(R.id.line3),
                line4 = view.findViewById(R.id.line4),
                line5 = view.findViewById(R.id.line5),
                line6 = view.findViewById(R.id.line6)
            )
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val item = getItem(position)
        viewHolder.line1.text = item.name
        viewHolder.line2.text = item.address
        viewHolder.line3.text = "Email: ${item.email}"
        viewHolder.line4.text = "Date: ${item.date}"
        viewHolder.line5.text =  "Fees: ${item.fees} ksh"
        viewHolder.line6.text = "Time: ${item.time}"

        return view
    }

    private data class ViewHolder(
        val line1: TextView,
        val line2: TextView,
        val line3: TextView,
        val line4: TextView,
        val line5: TextView,
        val line6: TextView
    )
}
