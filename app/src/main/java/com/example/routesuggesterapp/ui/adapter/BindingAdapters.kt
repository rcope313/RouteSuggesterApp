package com.example.routesuggesterapp.ui.adapter

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.routesuggesterapp.ui.adapter.models.FilterViewType
import com.example.routesuggesterapp.ui.adapter.models.FilterViewTypeList
import com.google.android.material.slider.RangeSlider

private const val TAG = "BindingAdapters"

@BindingAdapter("initValues")
fun RangeSlider.updateInitSliderValues(initialSliderValues: List<Int>) {
    Log.i(TAG, "Initial slider values: $initialSliderValues")
    initialSliderValues.map { it.toFloat() }
    values = initialSliderValues.map { it.toFloat() }
}

@BindingAdapter("submitData")
fun RecyclerView.submitData(data: FilterViewTypeList) {
    Log.i(TAG, "data: ${FilterViewTypeList.list}")
    (adapter as FilterFragmentAdapter).submitList(data.list as List<FilterViewType>?)
}
