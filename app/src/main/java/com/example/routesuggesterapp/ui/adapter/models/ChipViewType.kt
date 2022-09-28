package com.example.routesuggesterapp.ui.adapter.models

import com.example.routesuggesterapp.data.network.Criteria

class ChipViewType(override val title: Criteria) : FilterViewType() {
    override val viewType = ViewType.CHIP
}
