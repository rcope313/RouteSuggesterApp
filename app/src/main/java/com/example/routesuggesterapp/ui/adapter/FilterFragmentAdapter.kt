package com.example.routesuggesterapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
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

class FilterFragmentAdapter(val builder: RoutesSearchCriteria.Builder) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val dataSet: List<FilterViewType> = TODO()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val filterViewType = dataSet[position]
        when (filterViewType.viewType) {
            ViewType.CHIP -> (holder as ChipViewHolder).bind(filterViewType as ChipViewType)
            ViewType.SLIDER -> (holder as SliderViewHolder).bind(filterViewType as SliderViewType)
            ViewType.SWITCH -> (holder as ChipViewHolder).bind(filterViewType as ChipViewType)
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

    override fun getItemCount() =
        dataSet.size

    class ChipViewHolder(private var binding: FilterChipViewTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(chipViewType: ChipViewType) {
            binding.apply {
                binding.chipViewType = chipViewType
                low.setOnCheckedChangeListener { chip, isChecked ->
                    TODO()
                }
                moderate.setOnCheckedChangeListener { chip, isChecked ->
                    TODO()
                }
                considerable.setOnCheckedChangeListener { chip, isChecked ->
                    TODO()
                }
                high.setOnCheckedChangeListener { chip, isChecked ->
                    TODO()
                }
                extreme.setOnCheckedChangeListener { chip, isChecked ->
                    TODO()
                }
            }

        }
    }

    class SliderViewHolder(private var binding: FilterSliderViewTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(sliderViewType: SliderViewType) {
            binding.apply {
                binding.sliderViewType = sliderViewType
                rangeSlider.addOnChangeListener { slider, value, fromUser ->
                    val values = rangeSlider.values
                    TODO()
                }
            }
        }
    }

    class SwitchViewHolder(private var binding: FilterSwitchViewTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(switchViewType: SwitchViewType) {
            binding.apply {
                binding.switchViewType = switchViewType
                switchMaterial.setOnCheckedChangeListener { switch, isChecked ->
                    TODO()
                }
            }
        }
    }

    class TextFieldViewHolder(private var binding: FilterTextFieldViewTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(textFieldViewType: TextFieldViewType) {
            binding.apply {
                binding.textFieldViewType = textFieldViewType
                val inputText = filledTextField.editText?.text.toString()
                TODO()
            }
        }
    }

    companion object {
        const val CHIP_VAL = 0
        const val SLIDER_VAL = 1
        const val SWITCH_VAL = 2
        const val TEXTFIELD_VAL = 3
    }
}
