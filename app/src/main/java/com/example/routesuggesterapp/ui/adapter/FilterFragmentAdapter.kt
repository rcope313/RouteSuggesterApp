package com.example.routesuggesterapp.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.routesuggesterapp.databinding.FilterChipViewTypeBinding
import com.example.routesuggesterapp.databinding.FilterSliderViewTypeBinding
import com.example.routesuggesterapp.databinding.FilterSwitchViewTypeBinding
import com.example.routesuggesterapp.databinding.FragmentRouteListBinding
import com.example.routesuggesterapp.ui.adapter.models.ChipViewType
import com.example.routesuggesterapp.ui.adapter.models.FilterViewType
import com.example.routesuggesterapp.ui.adapter.models.SliderViewType
import com.example.routesuggesterapp.ui.adapter.models.SwitchViewType
import com.example.routesuggesterapp.ui.adapter.models.TextFieldViewType
import com.example.routesuggesterapp.ui.adapter.models.ViewType

class FilterFragmentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mDiffer: AsyncListDiffer<FilterViewType> = AsyncListDiffer(this, DiffCallback);

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val filterViewType = mDiffer.currentList[position]
        when (filterViewType.viewType) {
            ViewType.CHIP -> (holder as ChipViewHolder).bind(filterViewType as ChipViewType)
            ViewType.SLIDER -> (holder as SliderViewHolder).bind(filterViewType as SliderViewType)
            ViewType.SWITCH -> (holder as ChipViewHolder).bind(filterViewType as ChipViewType)
            ViewType.TEXTFIELD -> (holder as TextFieldViewHolder).bind(filterViewType as TextFieldViewType)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CHIP_VAL -> ChipViewHolder(TODO())
            SLIDER_VAL -> SliderViewHolder(TODO())
            SWITCH_VAL -> SwitchViewHolder(TODO())
            TEXTFIELD_VAL -> TextFieldViewHolder(TODO())
            else -> {throw IllegalStateException("Unrecognized view type.")}
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (mDiffer.currentList[position].viewType) {
            ViewType.CHIP -> CHIP_VAL
            ViewType.SLIDER -> SLIDER_VAL
            ViewType.SWITCH -> SWITCH_VAL
            ViewType.TEXTFIELD -> TEXTFIELD_VAL
        }
    }

    override fun getItemCount() =
        mDiffer.currentList.size

    class ChipViewHolder(private var binding: FilterChipViewTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(chipViewType: ChipViewType) {
            binding.apply {
                binding.chipViewType = chipViewType
                //binding.executePendingBindings()
            }
        }
    }

    class SliderViewHolder(private var binding: FilterSliderViewTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(sliderViewType: SliderViewType) {
            binding.apply {
                binding.sliderViewType = sliderViewType
                //binding.executePendingsBindings()
            }
        }
    }

    class SwitchViewHolder(private var binding: FilterSwitchViewTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(switchViewType: SwitchViewType) {
            binding.apply {
                binding.switchViewType = switchViewType
                //binding.executePendingsBindings()
            }
        }
    }

    class TextFieldViewHolder(private var binding: FragmentRouteListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(textViewType: TextFieldViewType) {
            binding.apply {
                TODO()
            }
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
