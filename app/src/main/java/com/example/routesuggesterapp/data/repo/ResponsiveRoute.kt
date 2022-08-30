package com.example.routesuggesterapp.data.repo

import com.example.routesuggesterapp.data.network.Route

class ResponsiveRoute(
    var favorite: Boolean,
    id: Int,
    routeName: String,
    mountainName: String,
    isStandardRoute: Boolean, 
    isSnowRoute: Boolean,
    grade: Int,
    trailhead: String,
    summitElevation: Int,
    gain: Int,
    length: Int,
    exposure: String,
    rockfallPotential: String,
    routeFinding: String,
    commitment: String,
    roadDifficulty: Int,
    routeUrl: String,
    trailheadUrl: String
)
    : Route(
    id,
    routeName,
    mountainName,
    isStandardRoute,
    isSnowRoute,
    grade,
    trailhead,
    summitElevation,
    gain,
    length,
    exposure,
    rockfallPotential,
    routeFinding,
    commitment,
    roadDifficulty,
    routeUrl,
    trailheadUrl,
)
