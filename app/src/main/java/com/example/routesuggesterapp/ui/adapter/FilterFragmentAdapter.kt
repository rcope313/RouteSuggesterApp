package com.example.routesuggesterapp.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.routesuggesterapp.ui.adapter.models.FilterViewType

class FilterFragmentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mDiffer: AsyncListDiffer<FilterViewType> = AsyncListDiffer(this, DiffCallback);

    override fun getItemCount() =
        mDiffer.currentList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = mDiffer.currentList[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        when (mDiffer.currentList[position]) {

        }

    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<FilterViewType>() {
            override fun areItemsTheSame(oldItem: FilterViewType, newItem: FilterViewType): Boolean {
                TODO()
            }

            override fun areContentsTheSame(oldItem: FilterViewType, newItem: FilterViewType): Boolean {
                TODO()
            }
        }
    }

}