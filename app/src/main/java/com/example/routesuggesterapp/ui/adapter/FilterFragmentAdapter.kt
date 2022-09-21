package com.example.routesuggesterapp.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.routesuggesterapp.data.repo.ResponsiveRoute

class FilterFragmentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mDiffer: AsyncListDiffer<ResponsiveRoute> = AsyncListDiffer(this, DiffCallback);

    override fun getItemCount() =
        mDiffer.currentList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = mDiffer.currentList[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<ResponsiveRoute>() {
            override fun areItemsTheSame(oldItem: ResponsiveRoute, newItem: ResponsiveRoute): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: ResponsiveRoute, newItem: ResponsiveRoute): Boolean {
                TODO()
            }
        }
    }

}