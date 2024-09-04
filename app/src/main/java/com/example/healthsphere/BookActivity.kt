package com.example.healthsphere

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar
import java.util.Locale


class BookActivity : AppCompatActivity() {
    private lateinit var backbtn: LinearLayout
    private lateinit var tv: TextView
    private lateinit var ed1: EditText
    private lateinit var ed2: EditText
    private lateinit var ed3: EditText
    private lateinit var ed4 : EditText
    private lateinit var timeButton: Button
    private lateinit var dateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book)
        backbtn= findViewById(R.id.backbtn)
        tv = findViewById(R.id.tv_title)
        ed1 = findViewById(R.id.uploadName)
        ed2 = findViewById(R.id.et_address)
        ed3 = findViewById(R.id.et_email)
        ed4 = findViewById(R.id.et_fees)
        timeButton = findViewById(R.id.time_et)
        timeButton.setOnClickListener {
            // Get the current time
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            // Create a TimePickerDialog
            val timePickerDialog = TimePickerDialog(
                this,
                { _: TimePicker, selectedHour: Int, selectedMinute: Int ->
                    // Format the selected time
                    val time = String.format(Locale.getDefault(), "%02d:%02d", selectedHour, selectedMinute)
                    // Set the time to the Button's text
                    timeButton.text = time
                },
                hour, minute, true // Use 24-hour format
            )
            // Show the dialog
            timePickerDialog.show()
        }
        dateButton = findViewById(R.id.dateEditText)

//        dateButton.setOnClickListener {
//            // Get the current date
//            val calendar = Calendar.getInstance()
//            val year = calendar.get(Calendar.YEAR)
//            val month = calendar.get(Calendar.MONTH)
//            val day = calendar.get(Calendar.DAY_OF_MONTH)
//            val currentDate = String.format(Locale.getDefault(), "%02d/%02d/%d", day, month + 1, year)
//            dateButton.text = currentDate
//            // Create a DatePickerDialog
//            val datePickerDialog = DatePickerDialog(
//                this,
//                { _, selectedYear, selectedMonth, selectedDay ->
//                    // Format the selected date
//                    val date = String.format(Locale.getDefault(), "%d/%d/%d", selectedDay, selectedMonth + 1, selectedYear)
//                    // Set the date to the Button's text
//                    dateButton.text = date
//                },
//                year, month, day // Set initial date
//            )
//
//            // Show the dialog
//            datePickerDialog.show()
//        }
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)
        val currentDate = String.format(Locale.getDefault(), "%02d/%02d/%d", currentDay, currentMonth + 1, currentYear)
        dateButton.text = currentDate
        dateButton.setOnClickListener {
            // Create a DatePickerDialog with the current date as default
            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Format the selected date
                    val date = String.format(Locale.getDefault(), "%02d/%02d/%d", selectedDay, selectedMonth + 1, selectedYear)
                    // Set the date to the Button's text
                    dateButton.text = date
                },
                currentYear, currentMonth, currentDay // Set initial date to current date
            )

            // Show the dialog
            datePickerDialog.show()
        }


        ed1.isFocusable = false
        ed1.isFocusableInTouchMode = false
        ed2.isFocusable = false
        ed2.isFocusableInTouchMode = false
        ed3.isFocusable = false
        ed3.isFocusableInTouchMode = false
        ed4.isFocusable = false
        ed4.isFocusableInTouchMode = false

// Get Intent and extract data
        val intent = intent
        val title = intent.getStringExtra("text1") ?: ""
        val fullname = intent.getStringExtra("text2") ?: ""
        val address = intent.getStringExtra("text3") ?: ""
        val contact = intent.getStringExtra("text4") ?: ""
        val fees = intent.getStringExtra("text5") ?: ""

// Set the extracted data to the views
        tv.text = title
        ed1.setText(fullname)
        ed2.setText(address)
        ed3.setText(contact)
        ed4.setText("Cons Fees: $fees")
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