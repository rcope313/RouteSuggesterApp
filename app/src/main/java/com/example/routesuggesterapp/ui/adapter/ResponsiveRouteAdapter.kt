package com.example.routesuggesterapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.routesuggesterapp.data.repo.ResponsiveRouteInfo
import com.example.routesuggesterapp.databinding.FragmentRouteListBinding

class ResponsiveRouteAdapter(private val onItemClick: (ResponsiveRouteInfo) -> Unit)
    : ListAdapter<ResponsiveRouteInfo, ResponsiveRouteAdapter.RouteViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteViewHolder {
        return RouteViewHolder(
            FragmentRouteListBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: RouteViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClick(current)
        }
        holder.bind(current)
    }

    class RouteViewHolder(private var binding: FragmentRouteListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(responsiveRouteInfo: ResponsiveRouteInfo) {
            binding.apply {
                TODO()
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<ResponsiveRouteInfo>() {
            override fun areItemsTheSame(oldItem: ResponsiveRouteInfo, newItem: ResponsiveRouteInfo): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: ResponsiveRouteInfo, newItem: ResponsiveRouteInfo): Boolean {
                TODO()
            }
        }
    }


}