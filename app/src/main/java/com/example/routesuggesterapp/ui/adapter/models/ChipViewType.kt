package com.example.routesuggesterapp.ui.adapter.models

class ChipViewType(
    override val title: String,
    val chipNames: List<String>) : FilterViewType() {
    override val viewType = ViewType.CHIP
}
