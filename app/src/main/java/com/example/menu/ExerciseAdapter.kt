package com.example.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExerciseAdapter : RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>(){

    var listOfData: List<Exercise> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ExerciseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val exerciseName = view.findViewById<TextView>(R.id.exerciseName)
        val exerciseCount = view.findViewById<TextView>(R.id.exerciseCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.exercise_rv_item,
            parent,
            false
        )

        return ExerciseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.exerciseName.text = listOfData[position].name
        holder.exerciseCount.text = listOfData[position].count.toString()

    }

    override fun getItemCount(): Int = listOfData.size
}