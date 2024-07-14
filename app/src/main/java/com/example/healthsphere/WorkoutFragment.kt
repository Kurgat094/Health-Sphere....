package com.example.healthsphere

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WorkoutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkoutFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapterClass: AdapterClass
    private lateinit var recyclerView: RecyclerView
    private lateinit var workoutArrayList: ArrayList<WorkoutItemModel>

    lateinit var ImageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var workouts : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WorkoutFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                WorkoutFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        datainitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapterClass = AdapterClass(workoutArrayList)
        recyclerView.adapter = adapterClass
    }

    private fun datainitialize(){
        workoutArrayList = arrayListOf<WorkoutItemModel>()
        ImageId = arrayOf(
            R.drawable.workout1,
            R.drawable.workout2,
            R.drawable.workout1,
            R.drawable.workout2,
            R.drawable.workout1,
            R.drawable.workout2,
            R.drawable.workout1

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
        for(i in ImageId.indices){
            val workouts = WorkoutItemModel(ImageId[i],heading[i])
            workoutArrayList.add(workouts)
        }
    }
}