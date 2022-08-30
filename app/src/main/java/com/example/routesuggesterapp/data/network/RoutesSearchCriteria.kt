package com.example.routesuggesterapp.data.network

import java.util.*

data class RoutesSearchCriteria(
    val routeName: Optional<String>,
    val mountainName: Optional<String>,
    val isStandardRoute: Optional<Boolean>,
    val isSnowRoute: Optional<Boolean>,
    val grade: Optional<Int>,
    val trailhead: Optional<String>,
    val summitElevation: Optional<Int>,
    val gain: Optional<Int>,
    val length: Optional<Int>,
    val exposure: Optional<String>,
    val rockfallPotential: Optional<String>,
    val routeFinding: Optional<String>,
    val commitment: Optional<String>,
    val roadDifficulty: Optional<String>
)
