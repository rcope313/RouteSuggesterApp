package com.example.routesuggesterapp.ui.adapter.models

class SwitchViewType(
    override val title: String,
    val isChecked: Boolean,
    ) : FilterViewType() {
    override val viewType = ViewType.SWITCH
}