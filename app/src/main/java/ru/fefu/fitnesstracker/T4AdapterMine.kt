package ru.fefu.fitnesstracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class T4AdapterMine(private val items: List<ActivityItem>, private val onItemClick: (Int) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ActivityItem.Header -> TYPE_HEADER
            is ActivityItem.Activity -> TYPE_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.t4_item_header, parent, false)
            )
            else -> ActivityViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.t4_item_activity_mine, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ActivityItem.Header -> (holder as HeaderViewHolder).bind(item)
            is ActivityItem.Activity -> (holder as ActivityViewHolder).bind(item, onItemClick)
        }
    }

    override fun getItemCount(): Int = items.size

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val dateText: TextView = view.findViewById(R.id.date_text)

        fun bind(item: ActivityItem.Header) {
            dateText.text = item.date
        }
    }

    class ActivityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val typeText: TextView = view.findViewById(R.id.typeText)
        private val distanceText: TextView = view.findViewById(R.id.distanceText)
        private val durationText: TextView = view.findViewById(R.id.durationText)
        private val timeAgoText: TextView = view.findViewById(R.id.timeAgoText)

        fun bind(item: ActivityItem.Activity, onItemClick: (Int) -> Unit) {
            typeText.text = item.type
            distanceText.text = item.distance
            durationText.text = item.duration
            timeAgoText.text = item.timeAgo

            itemView.setOnClickListener { onItemClick(item.id) }
        }
    }
}