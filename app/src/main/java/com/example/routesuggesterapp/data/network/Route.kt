package com.example.routesuggesterapp.data.network

open class Route(
    val id: Int,
    val routeName: String,
    val mountainName: String,
    val isStandardRoute: Boolean,
    val isSnowRoute: Boolean,
    val grade: Int,
    val trailhead: String,
    val summitElevation: Int,
    val gain: Int,
    val length: Int,
    val exposure: String,
    val rockfallPotential: String,
    val routeFinding: String,
    val commitment: String,
    val roadDifficulty: Int,
    val routeUrl: String,
    val trailheadUrl: String
)




