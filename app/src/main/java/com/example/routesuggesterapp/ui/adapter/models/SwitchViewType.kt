package com.example.routesuggesterapp.ui.adapter.models

import com.example.routesuggesterapp.data.network.Criteria

class SwitchViewType(
    override val title: Criteria,
    val isChecked: Boolean,
    ) : FilterViewType() {
    override val viewType = ViewType.SWITCH
}