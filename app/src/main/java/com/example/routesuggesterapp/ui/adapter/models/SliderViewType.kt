package com.example.routesuggesterapp.ui.adapter.models

import com.example.routesuggesterapp.data.network.Criteria

class SliderViewType(
    override val title: Criteria,
    val valueFrom: Int,
    val valueTo: Int,
    val initialSliderValues: List<Int>) : FilterViewType() {
    override val viewType = ViewType.SLIDER

    init {
        checkInitialSliderValuesSize()
    }

    private fun checkInitialSliderValuesSize() {
        if (initialSliderValues.size != 2) {
            throw IllegalStateException("Must provide an array of exactly two initial slider values.")
        }
    }
}
