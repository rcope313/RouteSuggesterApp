package com.example.routesuggesterapp.ui.adapter.models

import com.example.routesuggesterapp.data.network.Criteria

abstract class FilterViewType {
    abstract val viewType: ViewType
    abstract val title: Criteria
}
