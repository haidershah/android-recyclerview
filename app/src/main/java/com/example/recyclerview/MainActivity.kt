package com.example.recyclerview

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        displayListView(recyclerView)
    }

    private fun displayListView(recyclerView: RecyclerView) {
        val adapter = RandomNumberAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.add_btn).setOnClickListener {
            val randomNumber = RandomNumber(Random.nextInt(0, 100))
            adapter.addData(randomNumber)
        }
    }

    private fun displayGridView(recyclerView: RecyclerView) {
        val adapter = RandomNumberAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        findViewById<Button>(R.id.add_btn).setOnClickListener {
            val randomNumber = RandomNumber(Random.nextInt(0, 100))
            adapter.addData(randomNumber)
        }
    }

    private fun displayListViewWithHeader(recyclerView: RecyclerView) {

    }
}
