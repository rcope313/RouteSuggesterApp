package com.example.routesuggesterapp.ui.adapter.models

class SliderViewType(
    override val title: String,
    val beginVal: Int,
    val endVal: Int) : FilterViewType() {
    override val viewType = ViewType.SLIDER
}