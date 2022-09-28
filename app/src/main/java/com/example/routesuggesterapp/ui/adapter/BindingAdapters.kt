package com.example.routesuggesterapp.ui.adapter


import androidx.databinding.BindingAdapter
import com.google.android.material.slider.RangeSlider

object BindingAdapterUtils {
    @JvmStatic
    @BindingAdapter("app:values")
    fun updateInitSliderValues(view: RangeSlider, initialSliderValues: List<Int>) {
        initialSliderValues.map { it.toFloat() }
        view.values = initialSliderValues.map { it.toFloat() }
    }
}
