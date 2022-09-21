package com.example.routesuggesterapp.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.routesuggesterapp.ui.adapter.models.FilterViewType
import com.example.routesuggesterapp.ui.adapter.models.ViewType

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
        return when (mDiffer.currentList[position].viewType) {
            ViewType.CHIP -> CHIP_VAL
            ViewType.SLIDER -> SLIDER_VAL
            ViewType.SWITCH -> SWITCH_VAL
            ViewType.TEXTFIELD -> TEXTFIELD_VAL
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
        const val CHIP_VAL = 0
        const val SLIDER_VAL = 1
        const val SWITCH_VAL = 2
        const val TEXTFIELD_VAL = 3
    }
}
