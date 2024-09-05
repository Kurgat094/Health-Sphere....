package com.example.Adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.healthsphere.R
import com.example.healthsphere.WorkoutItemModel

class AdapterClass(private val dataList: ArrayList<WorkoutItemModel>):RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_workout_layout, parent, false)
        return ViewHolderClass(itemView)
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.workoutImageUrl)
        holder.rvTitle.text = currentItem.name
    }
    class ViewHolderClass(itemView: View):RecyclerView.ViewHolder(itemView) {
        val rvImage: ImageView = itemView.findViewById(R.id.workout1)
        val rvTitle: TextView = itemView.findViewById(R.id.title)
    }
}
//
//class WorkoutAdapter(private val itemList: List<WorkoutItemModel>):RecyclerView.Adapter<WorkoutAdapter.ViewHolderClass>() {
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): WorkoutAdapter.ViewHolderClass {
//        val binding = ItemWorkoutLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolderClass(binding)
//    }
//
//    override fun onBindViewHolder(holder: WorkoutAdapter.ViewHolderClass, position: Int) {
//        holder.bind(itemList[position])
//    }
//
//    override fun getItemCount(): Int {
//        return itemList.size
//    }
//    class ViewHolderClass(private val itembinding: ItemWorkoutLayoutBinding):
//        RecyclerView.ViewHolder(itembinding.root) {
//        fun bind(workoutItemModel: WorkoutItemModel) {
//            itembinding.apply {
//                title.text = workoutItemModel.name
//                //image catching/load
//                Glide.with(itembinding.root).load(workoutItemModel.workoutImageUrl).centerCrop()
//                    .into(itembinding.workout1)
//            }
//
//        }
//    }
//
//}
