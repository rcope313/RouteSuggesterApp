package com.example.routesuggesterapp.ui.adapter.models

class TextFieldViewType(
    override val title: String,
    val editTextFieldHint: String
    ) : FilterViewType() {
    override val viewType = ViewType.TEXT_FIELD
}