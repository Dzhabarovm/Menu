package com.example.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeeksAdapter : RecyclerView.Adapter<WeeksAdapter.AdapterViewHolder>() {

    var weekNames: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClick: ((Int) -> Unit)? = null

    inner class AdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val weekName = view.findViewById<TextView>(R.id.weekName)

        init {
            view.setOnClickListener {
                onItemClick?.invoke(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.week_rv_item,
            parent,
            false)

        return  AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.weekName.text = weekNames[position]
    }

    override fun getItemCount(): Int = weekNames.size
}