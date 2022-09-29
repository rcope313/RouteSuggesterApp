package com.example.routesuggesterapp.ui.adapter.models

import com.example.routesuggesterapp.data.network.Criteria

object FilterViewTypeList {
    val list = arrayListOf(
        TextFieldViewType(Criteria.MOUNTAIN_NAME, "Long's Peak"),
        TextFieldViewType(Criteria.ROUTE_NAME, "Keyhole Route"),
        SwitchViewType(Criteria.IS_STANDARD_ROUTE, true),
        SwitchViewType(Criteria.IS_SNOW_ROUTE, false),
        SliderViewType(Criteria.GRADE, 0, 5, listOf(0,1)),
        TextFieldViewType(Criteria.TRAILHEAD, "Long's Peak Trailhead"),
        SliderViewType(Criteria.SUMMIT_ELEVATION, 14000, 14438, listOf(14000, 14438)),
        SliderViewType(Criteria.GAIN, 0, 10000, listOf(0, 1000)),
        SliderViewType(Criteria.LENGTH, 0, 50, listOf(0, 5)),
        ChipViewType(Criteria.EXPOSURE),
        ChipViewType(Criteria.ROCKFALL_POTENTIAL),
        ChipViewType(Criteria.ROUTE_FINDING),
        ChipViewType(Criteria.COMMITMENT),
        SliderViewType(Criteria.ROAD_DIFFICULTY, 0, 6, listOf(0,1))
    )
}
