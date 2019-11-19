package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RandomNumberAdapter : RecyclerView.Adapter<RandomNumberAdapter.ViewHolder>() {
    private val data = mutableListOf<RandomNumber>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val numberView: TextView = view.findViewById(R.id.number)
        val removeButton: Button = view.findViewById(R.id.removeNumberBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_random_number, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.numberView.text = item.number.toString()
        holder.removeButton.setOnClickListener {
            data.removeAt(position)
            notifyDataSetChanged()
        }
    }

    fun addData(randomNumber: RandomNumber) {
        data.add(0, randomNumber)
        notifyDataSetChanged()
    }
}
