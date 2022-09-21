package com.example.routesuggesterapp.ui.adapter.models

class SliderViewType(
    override val title: String,
    val valueFrom: Int,
    val valueTo: Int,
    val stepSize: Int,
    val initialSliderValues: IntArray) : FilterViewType() {
    override val viewType = ViewType.SLIDER
}