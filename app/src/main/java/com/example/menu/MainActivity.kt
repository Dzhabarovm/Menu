package com.example.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private var weeksRecyclerView: RecyclerView? = null
    private var exerciseRecyclerView: RecyclerView? = null
    private var myWeeksAdapter = WeeksAdapter()
    private var myExerciseAdapter = ExerciseAdapter()
    private var myData = MyData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setData(0)

        myWeeksAdapter.onItemClick = {
            setData(it)
        }

        weeksRecyclerView = findViewById(R.id.menuRecyclerView)
        weeksRecyclerView?.adapter = myWeeksAdapter
        exerciseRecyclerView = findViewById(R.id.exerciseRecyclerView)
        exerciseRecyclerView?.adapter = myExerciseAdapter

        myWeeksAdapter.weekNames = MyData().monthData
    }

    private fun setData(categoryIndex: Int) {
        val chosenData = mutableListOf<Exercise>()
        for (element in myData.exercises) {
            if (element.category == categoryIndex) {
                chosenData.add(element)
            }
        }
        Log.d(TAG, "$chosenData")
        myExerciseAdapter.listOfData = chosenData
    }

}

data class Exercise(
    val name: String,
    val count: Int,
    val category: Int
)

class MyData {
    val monthData = listOf(
        "Sunday",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
    )

    val exercises = listOf(
        Exercise("Run One Times", 1, 0),
        Exercise("Run Two Times", 2, 1),
        Exercise("Run Three Times", 3, 2),
        Exercise("Run Four Times", 4, 0),
        Exercise("Run Five Times", 5, 1),
        Exercise("Run Six Times", 1, 3),
        Exercise("Run Seven Times", 2, 0),
        Exercise("Run Eight Times", 3, 1),
        Exercise("Run Nine Times", 4, 3),
        Exercise("Run Ten Times", 5, 7),
        Exercise("Run Five Times", 5, 5),
        Exercise("Run One Times", 5, 2),
        Exercise("Run Eleven Times", 5, 4),
        Exercise("Run Seven Times", 5, 4),
        Exercise("Run Nine Times", 5, 7),
        Exercise("Run Nine Times", 5, 5),
        Exercise("Run Ten Times", 5, 6),
        Exercise("Run Two Times", 5, 1),
        Exercise("Run Many Times", 5, 6),
        Exercise("Run Lot of Times", 5, 7),
    )
}