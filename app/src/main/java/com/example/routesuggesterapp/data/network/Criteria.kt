package com.example.routesuggesterapp.data.network

enum class Criteria {
    ROUTE_NAME, MOUNTAIN_NAME, IS_STANDARD_ROUTE, IS_SNOW_ROUTE, GRADE, TRAILHEAD, SUMMIT_ELEVATION,
    GAIN, LENGTH, EXPOSURE, ROCKFALL_POTENTIAL, ROUTE_FINDING, COMMITMENT, ROAD_DIFFICULTY;

    override fun toString(): String {
        return when (this) {
            ROUTE_NAME -> "Route Name"
            MOUNTAIN_NAME -> "Mountain Name"
            IS_STANDARD_ROUTE -> "Standard Route Only"
            IS_SNOW_ROUTE ->  "Snow Route Only"
            GRADE -> "Grade"
            TRAILHEAD -> "Trailhead"
            SUMMIT_ELEVATION -> "Summit Elevation"
            GAIN -> "Gain"
            LENGTH -> "Length"
            EXPOSURE -> "Exposure"
            ROCKFALL_POTENTIAL -> "Rockfall Potential"
            ROUTE_FINDING -> "Route Finding"
            COMMITMENT -> "Commitment"
            ROAD_DIFFICULTY -> "Road Difficulty"
        }
    }

    fun fromString(criteria: String): Criteria {
       return when (criteria) {
           "Route Name" -> ROUTE_NAME
           "Mountain Name" -> MOUNTAIN_NAME
           "Standard Route Only" -> IS_STANDARD_ROUTE
           "Snow Route Only" -> IS_SNOW_ROUTE
           "Grade" -> GRADE
           "Trailhead" -> TRAILHEAD
           "Summit Elevation" -> SUMMIT_ELEVATION
           "Gain" -> GAIN
           "Length" -> LENGTH
           "Exposure" -> EXPOSURE
           "Rockfall Potential" -> ROCKFALL_POTENTIAL
           "Route Finding" -> ROUTE_FINDING
           "Commitment" -> COMMITMENT
           "Road Difficulty" -> ROAD_DIFFICULTY
           else -> throw IllegalArgumentException("Provided criteria string is not an enum Criteria member.")
       }
    }
}
