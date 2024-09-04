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
    private val doctorDetails1 = arrayOf(
        arrayOf(
            "Doctor Name: Ajit Saste",
            "Hospital Address: Pimpri",
            "Exp: 5yrs",
            "Mobile No: 9898989898",
            "608"
        ),
        arrayOf(
            "Doctor Name: Prasad Pawar",
            "Hospital Address: Nigdi",
            "Exp: 15yrs",
            "Mobile No: 7898989898",
            "1900"
        ),
        arrayOf(
            "Doctor Name: Swapnil Kals",
            "Hospital Address: Pune",
            "Exp: 8yrs",
            "Mobile No: 8898989898",
            "500"
        ),
        arrayOf(
            "Doctor Name: Deepak Deshmukh",
            "Hospital Address: Chinchwad",
            "Exp: 6yrs",
            "Mobile No: 9898000000",
            "500"
        ),
        arrayOf(
            "Doctor Name: Ashok Panda",
            "Hospital Address: Katraj",
            "Exp: 7yrs",
            "Mobile No: 7798989898",
            "800"
        )
    )
    private val doctorDetails2 = arrayOf(
        arrayOf(
            "Doctor Name: Ajit Saste",
            "Hospital Address: Pimpri",
            "Exp: 5yrs",
            "Mobile No: 9898989898",
            "608"
        ),
        arrayOf(
            "Doctor Name: Prasad Pawar",
            "Hospital Address: Nigdi",
            "Exp: 15yrs",
            "Mobile No: 7898989898",
            "1900"
        ),
        arrayOf(
            "Doctor Name: Swapnil Kals",
            "Hospital Address: Pune",
            "Exp: 8yrs",
            "Mobile No: 8898989898",
            "500"
        ),
        arrayOf(
            "Doctor Name: Deepak Deshmukh",
            "Hospital Address: Chinchwad",
            "Exp: 6yrs",
            "Mobile No: 9898000000",
            "500"
        ),
        arrayOf(
            "Doctor Name: Ashok Panda",
            "Hospital Address: Katraj",
            "Exp: 7yrs",
            "Mobile No: 7798989898",
            "800"
        )
    )
    private val doctorDetails3 = arrayOf(
        arrayOf(
            "Doctor Name: Ajit Saste",
            "Hospital Address: Pimpri",
            "Exp: 5yrs",
            "Mobile No: 9898989898",
            "608"
        ),
        arrayOf(
            "Doctor Name: Prasad Pawar",
            "Hospital Address: Nigdi",
            "Exp: 15yrs",
            "Mobile No: 7898989898",
            "1900"
        ),
        arrayOf(
            "Doctor Name: Swapnil Kals",
            "Hospital Address: Pune",
            "Exp: 8yrs",
            "Mobile No: 8898989898",
            "500"
        ),
        arrayOf(
            "Doctor Name: Deepak Deshmukh",
            "Hospital Address: Chinchwad",
            "Exp: 6yrs",
            "Mobile No: 9898000000",
            "500"
        ),
        arrayOf(
            "Doctor Name: Ashok Panda",
            "Hospital Address: Katraj",
            "Exp: 7yrs",
            "Mobile No: 7798989898",
            "800"
        )
    )
    private val doctorDetails4 = arrayOf(
        arrayOf(
            "Doctor Name: Ajit Saste",
            "Hospital Address: Pimpri",
            "Exp: 5yrs",
            "Mobile No: 9898989898",
            "608"
        ),
        arrayOf(
            "Doctor Name: Prasad Pawar",
            "Hospital Address: Nigdi",
            "Exp: 15yrs",
            "Mobile No: 7898989898",
            "1900"
        ),
        arrayOf(
            "Doctor Name: Swapnil Kals",
            "Hospital Address: Pune",
            "Exp: 8yrs",
            "Mobile No: 8898989898",
            "500"
        ),
        arrayOf(
            "Doctor Name: Deepak Deshmukh",
            "Hospital Address: Chinchwad",
            "Exp: 6yrs",
            "Mobile No: 9898000000",
            "500"
        ),
        arrayOf(
            "Doctor Name: Ashok Panda",
            "Hospital Address: Katraj",
            "Exp: 7yrs",
            "Mobile No: 7798989898",
            "800"
        )
    )
    private val doctorDetails5 = arrayOf(
        arrayOf(
            "Doctor Name: Ajit Saste",
            "Hospital Address: Pimpri",
            "Exp: 5yrs",
            "Mobile No: 9898989898",
            "608"
        ),
        arrayOf(
            "Doctor Name: Prasad Pawar",
            "Hospital Address: Nigdi",
            "Exp: 15yrs",
            "Mobile No: 7898989898",
            "1900"
        ),
        arrayOf(
            "Doctor Name: Swapnil Kals",
            "Hospital Address: Pune",
            "Exp: 8yrs",
            "Mobile No: 8898989898",
            "500"
        ),
        arrayOf(
            "Doctor Name: Deepak Deshmukh",
            "Hospital Address: Chinchwad",
            "Exp: 6yrs",
            "Mobile No: 9898000000",
            "500"
        ),
        arrayOf(
            "Doctor Name: Ashok Panda",
            "Hospital Address: Katraj",
            "Exp: 7yrs",
            "Mobile No: 7798989898",
            "800"
        )
    )
    private lateinit var tvTittle :TextView
    private lateinit var backbtn : LinearLayout

    var doctorDetails = arrayOf<Array<String>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doctor_details)
        backbtn = findViewById(R.id.backbtn)
        tvTittle = findViewById(R.id.tvTittle)
  //      val item: HashMap<String, String>
//        val list: ArrayList<Any>

        val title = intent.getStringExtra("title")
        tvTittle.text = title

        if (title != null) {
            if(title.compareTo("family physisian")==0){
                doctorDetails = doctorDetails1
            }
        }
        if (title == "Dietician") {
            doctorDetails = doctorDetails2
        }
        if (title == "Opticle unit") {
            doctorDetails = doctorDetails3
        }
        if (title == "family physician") {
            doctorDetails = doctorDetails4
        }
        if (title == "Dentist specialist") {
            doctorDetails = doctorDetails5
        }
        val list: MutableList<Map<String, String>> = ArrayList()
        for (i in 0 until doctorDetails.size) {
            val item: MutableMap<String, String> = HashMap()
            item["line1"] = doctorDetails.get(i).get(0)
            item["line2"] = doctorDetails.get(i).get(1)
            item["line3"] = doctorDetails.get(i).get(2)
            item["line4"] = doctorDetails.get(i).get(3)
            item["line5"] = ("Cons Fees:" + doctorDetails.get(i).get(4)).toString() + "/-"
            list.add(item)
        }
        val adapter = SimpleAdapter(
            this,
            list,
            R.layout.multilines, // Layout for each item
            arrayOf("line1", "line2", "line3", "line4", "line5"),
            intArrayOf(R.id.line1, R.id.line2, R.id.line3, R.id.line4, R.id.line5)
        )
        // Set the adapter to the ListView
        val listView: ListView = findViewById(R.id.listviewdocdetails)
        listView.adapter = adapter

        // Set an item click listener
        listView.setOnItemClickListener { _, _, position, _ ->
            // Get the clicked item's data
            val selectedItem = list[position]
            val doctorName = selectedItem["line1"] ?: "Unknown"
            val address = selectedItem["line2"] ?: ""
            val contact = selectedItem["line3"] ?: ""
            val fees = selectedItem["line5"] ?: ""

            // Create an Intent to start BookActivity
            val intent = Intent(this, BookActivity::class.java)
            // Pass data to the new activity
            intent.putExtra("text1", "Appointments" )
            intent.putExtra("text2", doctorName) // Replace with actual data
            intent.putExtra("text3", address)
            intent.putExtra("text4", contact)
            intent.putExtra("text5", fees)
            startActivity(intent)
        }
        backbtn.setOnClickListener{
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