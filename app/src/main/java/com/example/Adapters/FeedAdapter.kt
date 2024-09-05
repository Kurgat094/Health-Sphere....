package com.example.recyclerview
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.healthsphere.Feeds
import com.example.healthsphere.R
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapterClass(private val dataList1: ArrayList<Feeds>):RecyclerView.Adapter<FeedAdapterClass.ViewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feed_list_item, parent, false)
        return ViewHolderClass(itemView)
    }
    override fun getItemCount(): Int {
        return dataList1.size
    }
    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList1[position]
        holder.rvImage.setImageResource(currentItem.titleImage)
        holder.rvTitle.text = currentItem.heading
        holder.rvFeedDesc.text = currentItem.feedDesc
    }
    class ViewHolderClass(itemView: View):RecyclerView.ViewHolder(itemView) {
        val rvImage: ShapeableImageView = itemView.findViewById(R.id.title_image)
        val rvTitle: TextView = itemView.findViewById(R.id.feedHeading)
        val rvFeedDesc: TextView = itemView.findViewById(R.id.feedDesc)
    }
}