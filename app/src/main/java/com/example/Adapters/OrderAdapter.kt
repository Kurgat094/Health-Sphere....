package com.example.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.BaseAdapter
import com.example.healthsphere.R
import com.example.models.Order

class OrderAdapter(private val context: Context, private val orderList: List<Order>) : BaseAdapter() {

    override fun getCount(): Int = orderList.size

    override fun getItem(position: Int): Any = orderList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.multilines, parent, false)

        val order = orderList[position]
        val tvName = view.findViewById<TextView>(R.id.line1)
        val tvAddress = view.findViewById<TextView>(R.id.line2)
        val tvEmail = view.findViewById<TextView>(R.id.line6)
        val tvDate = view.findViewById<TextView>(R.id.line4)
        val tvTime = view.findViewById<TextView>(R.id.line3)
        val tvPrice = view.findViewById<TextView>(R.id.line5)

        tvName.text = order.name
        tvAddress.text = "Address: ${order.address}"
        tvEmail.text = order.email
        tvDate.text =  "Date: ${order.date}"
        tvTime.text = "Time: ${order.time}"
        tvPrice.text = order.price

        return view
    }
}
