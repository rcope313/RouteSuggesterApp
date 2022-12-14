package com.example.routesuggesterapp.ui.adapter.models

import com.example.routesuggesterapp.data.network.Criteria

class TextFieldViewType(
    override val title: Criteria,
    val editTextFieldHint: String
    ) : FilterViewType() {
    override val viewType = ViewType.TEXT_FIELD
}