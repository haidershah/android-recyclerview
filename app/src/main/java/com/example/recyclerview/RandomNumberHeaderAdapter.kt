package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RandomNumberHeaderAdapter : RecyclerView.Adapter<RandomNumberHeaderAdapter.ViewHolder>() {
    private val data = mutableListOf<RandomNumber>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val numberView: TextView = view.findViewById(R.id.number)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_random_number_header, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.numberView.text = item.number.toString()
    }

    fun addData(randomNumbers: List<RandomNumber>) {
        data.addAll(randomNumbers)
        notifyDataSetChanged()
    }
}
