package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healthsphere.Feeds
import com.example.healthsphere.R
import com.example.recyclerview.FeedAdapterClass

class FeedFragment : Fragment() {

    private lateinit var adapterClass: FeedAdapterClass
    private lateinit var recyclerView: RecyclerView
    private lateinit var feedsArrayList: ArrayList<Feeds>

    lateinit var ImageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var headingDesc : Array<String>
    lateinit var workouts : Array<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        datainitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.Feedrecycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapterClass = FeedAdapterClass(feedsArrayList)
        recyclerView.adapter = adapterClass
    }

    private fun datainitialize() {
        feedsArrayList = arrayListOf<Feeds>()
        ImageId = arrayOf(
            R.drawable.healthimg1,
            R.drawable.healthimg1,
            R.drawable.healthimg2,
            R.drawable.healthimg1,
            R.drawable.healthimg2,
            R.drawable.healthimg1,
            R.drawable.healthimg2,
            R.drawable.healthimg1
        )
        heading = arrayOf(
            getString(R.string.workout1),
            getString(R.string.workout2),
            getString(R.string.workout3),
            getString(R.string.workout4),
            getString(R.string.workout5),
            getString(R.string.workout6),
            getString(R.string.workout7),
            getString(R.string.workout8)
        )
        headingDesc = arrayOf(
            "Date Picker",
            "Edit Text",
            "Text View",
            "time Picker",
            "ListView",
            "camera",
            "imageView ",
            "checkBox",
            )
        for(i in ImageId.indices){
            val workouts = Feeds(ImageId[i],heading[i], headingDesc[i])
            feedsArrayList.add(workouts)
        }
    }

}