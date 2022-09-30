package com.example.routesuggesterapp.ui.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.routesuggesterapp.ui.adapter.models.FilterViewType
import com.example.routesuggesterapp.ui.adapter.models.FilterViewTypeList
import com.example.routesuggesterapp.ui.adapter.models.SliderViewType
import com.google.android.material.slider.RangeSlider

private const val TAG = "BindingAdapters"

@BindingAdapter("values")
fun RangeSlider.setRangeSliderValues(sliderViewType: SliderViewType) {
    values = sliderViewType.initialSliderValues.map { it.toFloat() }
    valueFrom = sliderViewType.valueFrom.toFloat()
    valueTo = sliderViewType.valueTo.toFloat()
}

@BindingAdapter("submitData")
fun RecyclerView.submitData(data: FilterViewTypeList) {
    (adapter as FilterFragmentAdapter).submitList(data.list as List<FilterViewType>?)
}
