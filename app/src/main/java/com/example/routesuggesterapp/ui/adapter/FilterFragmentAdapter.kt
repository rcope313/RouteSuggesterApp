package com.example.routesuggesterapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.routesuggesterapp.data.network.Criteria
import com.example.routesuggesterapp.data.network.RoutesSearchCriteria
import com.example.routesuggesterapp.databinding.FilterChipViewTypeBinding
import com.example.routesuggesterapp.databinding.FilterSliderViewTypeBinding
import com.example.routesuggesterapp.databinding.FilterSwitchViewTypeBinding
import com.example.routesuggesterapp.databinding.FilterTextFieldViewTypeBinding
import com.example.routesuggesterapp.ui.adapter.models.ChipViewType
import com.example.routesuggesterapp.ui.adapter.models.FilterViewType
import com.example.routesuggesterapp.ui.adapter.models.SliderViewType
import com.example.routesuggesterapp.ui.adapter.models.SwitchViewType
import com.example.routesuggesterapp.ui.adapter.models.TextFieldViewType
import com.example.routesuggesterapp.ui.adapter.models.ViewType

class FilterFragmentAdapter(val builder: RoutesSearchCriteria.Builder)
    : ListAdapter<FilterViewType, RecyclerView.ViewHolder>(DiffCallback) {
    lateinit var dataSet: List<FilterViewType>

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val filterViewType = dataSet[position]
        when (filterViewType.viewType) {
            ViewType.CHIP -> (holder as ChipViewHolder).bind(filterViewType as ChipViewType)
            ViewType.SLIDER -> (holder as SliderViewHolder).bind(filterViewType as SliderViewType)
            ViewType.SWITCH -> (holder as SwitchViewHolder).bind(filterViewType as SwitchViewType)
            ViewType.TEXT_FIELD -> (holder as TextFieldViewHolder).bind(filterViewType as TextFieldViewType)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            CHIP_VAL -> ChipViewHolder(FilterChipViewTypeBinding.inflate(layoutInflater, parent, false))
            SLIDER_VAL -> SliderViewHolder(FilterSliderViewTypeBinding.inflate(layoutInflater, parent, false))
            SWITCH_VAL -> SwitchViewHolder(FilterSwitchViewTypeBinding.inflate(layoutInflater, parent, false))
            TEXTFIELD_VAL -> TextFieldViewHolder(FilterTextFieldViewTypeBinding.inflate(layoutInflater, parent, false))
            else -> {throw IllegalStateException("Unrecognized view type.")}
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (dataSet[position].viewType) {
            ViewType.CHIP -> CHIP_VAL
            ViewType.SLIDER -> SLIDER_VAL
            ViewType.SWITCH -> SWITCH_VAL
            ViewType.TEXT_FIELD -> TEXTFIELD_VAL
        }
    }

    inner class ChipViewHolder(private var binding: FilterChipViewTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(chipViewType: ChipViewType) {
            val chipList = mutableListOf<String>()
            val criteria = chipViewType.title

            binding.apply {
                binding.chipViewType = chipViewType
                low.setOnCheckedChangeListener(ChipListener(chipList, criteria))
                moderate.setOnCheckedChangeListener(ChipListener(chipList, criteria))
                considerable.setOnCheckedChangeListener(ChipListener(chipList, criteria))
                high.setOnCheckedChangeListener(ChipListener(chipList, criteria))
                extreme.setOnCheckedChangeListener(ChipListener(chipList, criteria))
            }
        }

        inner class ChipListener(
            private val chipList: MutableList<String>,
            private val criteria: Criteria) : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(chip: CompoundButton?, isChecked: Boolean) {
                val chipTitle = chip?.text.toString()
                if (isChecked) chipList.add(chipTitle) else chipList.remove(chipTitle)
                builder.applyCriteriaByChip(criteria, chipList)
            }
        }
    }

    inner class SliderViewHolder(private var binding: FilterSliderViewTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(sliderViewType: SliderViewType) {
            val criteria = sliderViewType.title
            binding.apply {
                binding.sliderViewType = sliderViewType
                rangeSlider.setRangeSliderValues(sliderViewType)
                rangeSlider.addOnChangeListener { slider, _, _ ->
                    builder.applyCriteriaBySlider(criteria, slider.values)
                }
            }
        }
    }

    inner class SwitchViewHolder(private var binding: FilterSwitchViewTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(switchViewType: SwitchViewType) {
            val criteria = switchViewType.title
            binding.apply {
                binding.switchViewType = switchViewType
                switchMaterial.setOnCheckedChangeListener { _, isChecked ->
                    builder.applyCriteriaBySwitch(criteria, isChecked)
                }
            }
        }
    }

    inner class TextFieldViewHolder(private var binding: FilterTextFieldViewTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(textFieldViewType: TextFieldViewType) {
            val criteria = textFieldViewType.title
            binding.apply {
                binding.textFieldViewType = textFieldViewType
                val inputText = filledTextField.editText?.text.toString()
                builder.applyCriteriaByTextField(criteria, inputText)
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<FilterViewType>() {
            override fun areItemsTheSame(oldItem: FilterViewType, newItem: FilterViewType): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: FilterViewType, newItem: FilterViewType): Boolean {
                return oldItem.title == newItem.title
            }
        }
        const val CHIP_VAL = 0
        const val SLIDER_VAL = 1
        const val SWITCH_VAL = 2
        const val TEXTFIELD_VAL = 3
    }
}
