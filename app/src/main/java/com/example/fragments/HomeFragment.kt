package com.example.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.example.healthsphere.FindDoctors
import com.example.healthsphere.LabTestActivity
import com.example.healthsphere.R

class HomeFragment : Fragment() {
    private lateinit var doctorsCard: RelativeLayout
    private lateinit var labtest: RelativeLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        doctorsCard = view.findViewById(R.id.doctorsCard)
        labtest = view.findViewById(R.id.labtest)

        labtest.setOnClickListener {
            val intentLab = Intent(activity, LabTestActivity::class.java)
            startActivity(intentLab)
        }
        doctorsCard.setOnClickListener{
            val intent = Intent(activity, FindDoctors::class.java)
            startActivity(intent)
        }
        return view
    }

}