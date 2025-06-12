package ru.fefu.fitnesstracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class T5AdapterSportsType(
    private val sportsItems: List<SportItem>
) : RecyclerView.Adapter<T5AdapterSportsType.ViewHolder>() {

    data class SportItem(
        val name: String,
        val iconResId: Int
    )

    var onItemSelected: ((String) -> Unit)? = null

    private var selectedPosition = RecyclerView.NO_POSITION

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val typeName: TextView = itemView.findViewById(R.id.typeText)
        private val sportIcon: ImageView = itemView.findViewById(R.id.sportIcon)
        private val rootView: View = itemView.findViewById(R.id.rootView)

        fun bind(item: SportItem, position: Int) {
            typeName.text = item.name
            sportIcon.setImageResource(item.iconResId)
            rootView.isSelected = position == selectedPosition

            itemView.setOnClickListener {
                updateSelection(position)
                onItemSelected?.invoke(item.name)
            }
        }

        private fun updateSelection(newPosition: Int) {
            val previous = selectedPosition
            selectedPosition = newPosition
            notifyItemChanged(previous)
            notifyItemChanged(selectedPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.t5_item_activity_type, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(sportsItems[position], position)
    }

    override fun getItemCount(): Int = sportsItems.size
}