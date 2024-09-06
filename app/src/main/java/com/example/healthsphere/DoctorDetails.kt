package com.example.healthsphere

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class DoctorDetails : AppCompatActivity() {
    private lateinit var tvTittle: TextView
    private lateinit var backbtn: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doctor_details)
        backbtn = findViewById(R.id.backbtn)
        tvTittle = findViewById(R.id.tvTittle)

        val title = intent.getStringExtra("title")
        val doctorDetails = intent.getSerializableExtra("doctorDetails") as? Array<Array<String>> ?: arrayOf()
        tvTittle.text = title
        val list: MutableList<Map<String, String>> = ArrayList()
        for (i in doctorDetails.indices) {
            val item: MutableMap<String, String> = HashMap()
            item["line1"] = doctorDetails[i][0]
            item["line2"] = doctorDetails[i][1]
            item["line3"] = doctorDetails[i][2]
            item["line6"] =doctorDetails[i][3]
            item["line5"] =doctorDetails[i][4]
            list.add(item)
        }
        val adapter = SimpleAdapter(
            this,
            list,
            R.layout.multilines,
            arrayOf("line1", "line2", "line3", "line6", "line5"),
            intArrayOf(R.id.line1, R.id.line2, R.id.line3, R.id.line6, R.id.line5)
        )
        val listView: ListView = findViewById(R.id.listviewdocdetails)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = list[position]
            val doctorName = selectedItem["line1"] ?: "Unknown"
            val address = selectedItem["line2"] ?: ""
            val exp = selectedItem["line3"] ?: ""
            val email = selectedItem["line6"] ?: ""
            val fees = selectedItem["line5"] ?: ""
            val intent = Intent(this, BookActivity::class.java)
            intent.putExtra("text1", doctorName )
            intent.putExtra("text2", email)
            intent.putExtra("text3", address)
            intent.putExtra("text4", exp)
            intent.putExtra("text5", fees)
            startActivity(intent)
        }
        backbtn.setOnClickListener {
            val backintent = Intent(this, FindDoctors::class.java)
            startActivity(backintent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}