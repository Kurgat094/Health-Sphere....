package com.example.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.models.Order
import com.example.healthsphere.R

class OrderAdapter(private val context: Context, private val items: List<Order>) : BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Order = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.multilines2, parent, false)
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
        viewHolder.line4.text = "Price: ${item.price} ksh"
        viewHolder.line5.text = "Date: ${item.date}"
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


//package com.example.Adapters
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import android.widget.BaseAdapter
//import com.example.healthsphere.R
//import com.example.models.Order
//
//class OrderAdapter(private val context: Context, private val orderList: List<Order>) : BaseAdapter() {
//
//    override fun getCount(): Int = orderList.size
//
//    override fun getItem(position: Int): Any = orderList[position]
//
//    override fun getItemId(position: Int): Long = position.toLong()
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.multilines, parent, false)
//
//        val order = orderList[position]
//        val tvName = view.findViewById<TextView>(R.id.line1)
//        val tvAddress = view.findViewById<TextView>(R.id.line2)
//        val tvEmail = view.findViewById<TextView>(R.id.line6)
//        val tvDate = view.findViewById<TextView>(R.id.line4)
//        val tvTime = view.findViewById<TextView>(R.id.line3)
//        val tvPrice = view.findViewById<TextView>(R.id.line5)
//
//        tvName.text = order.name
//        tvAddress.text = "Address: ${order.address}"
//        tvEmail.text = order.email
//        tvDate.text =  "Date: ${order.date}"
//        tvTime.text = "Time: ${order.time}"
//        tvPrice.text = order.price
//
//        return view
//    }
//}
