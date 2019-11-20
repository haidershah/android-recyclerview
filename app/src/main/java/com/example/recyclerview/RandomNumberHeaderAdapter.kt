package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.ClassCastException

private const val ITEM_VIEW_TYPE_HEADER = 0
private const val ITEM_VIEW_TYPE_ITEM = 1

class RandomNumberHeaderAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data = mutableListOf<DataItem>()

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val numberView: TextView = view.findViewById(R.id.number)
    }

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val headerView: TextView = view.findViewById(R.id.header)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> {
                val view =
                    layoutInflater.inflate(R.layout.list_item_random_number_header, parent, false)
                HeaderViewHolder(view)
            }
            ITEM_VIEW_TYPE_ITEM -> {
                val view =
                    layoutInflater.inflate(R.layout.list_item_random_number_item, parent, false)
                ItemViewHolder(view)
            }
            else -> {
                throw ClassCastException("Unknown viewType $viewType")
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is DataItem.RandomNumberItem -> ITEM_VIEW_TYPE_ITEM
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> {
                val item = data[position] as DataItem.RandomNumberItem
                holder.numberView.text = item.randomNumber.number.toString()
            }
        }
    }

    fun addData(randomNumbers: List<RandomNumber>) {
        data.add(DataItem.Header)

        data.addAll(randomNumbers.map {
            DataItem.RandomNumberItem(it)
        })
        notifyDataSetChanged()
    }
}

sealed class DataItem {
    data class RandomNumberItem(val randomNumber: RandomNumber) : DataItem()
    object Header : DataItem()
}
