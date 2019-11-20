package com.example.recyclerview

import android.os.Bundle
import android.view.View
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
        displayGridViewWithHeader(recyclerView)
    }

    private fun displayListView(recyclerView: RecyclerView) {
        val adapter = RandomNumberAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.add_btn).visibility = View.VISIBLE
        findViewById<Button>(R.id.add_btn).setOnClickListener {
            val randomNumber = RandomNumber(Random.nextInt(0, 100))
            adapter.addData(randomNumber)
        }
    }

    private fun displayGridView(recyclerView: RecyclerView) {
        val adapter = RandomNumberAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        findViewById<Button>(R.id.add_btn).visibility = View.VISIBLE
        findViewById<Button>(R.id.add_btn).setOnClickListener {
            val randomNumber = RandomNumber(Random.nextInt(0, 100))
            adapter.addData(randomNumber)
        }
    }

    private fun displayListViewWithHeader(recyclerView: RecyclerView) {
        val adapter = RandomNumberHeaderAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // add data
        val randomNumbers = mutableListOf<RandomNumber>()
        for (i in 1..19) {
            randomNumbers.add(RandomNumber(Random.nextInt(0, 100)))
        }
        adapter.addData(randomNumbers)
    }

    private fun displayGridViewWithHeader(recyclerView: RecyclerView) {
        val adapter = RandomNumberHeaderAdapter()
        val manager = GridLayoutManager(this, 3)
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    0 -> 3
                    else -> 1
                }
            }
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = manager

        // add data
        val randomNumbers = mutableListOf<RandomNumber>()
        for (i in 1..19) {
            randomNumbers.add(RandomNumber(Random.nextInt(0, 100)))
        }
        adapter.addData(randomNumbers)
    }
}
