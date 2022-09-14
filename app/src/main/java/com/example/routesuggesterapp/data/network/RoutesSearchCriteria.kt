package com.example.routesuggesterapp.data.network

class RoutesSearchCriteria private constructor (
    val routeName: String?,
    val mountainName: String?,
    val sStandardRoute: Boolean?,
    val isSnowRoute: Boolean?,
    val grade: Int?,
    val trailhead: String?,
    val summitElevation: Int?,
    val gain: Int?,
    val length: Int?,
    val exposure: String?,
    val rockfallPotential: String?,
    val routeFinding: String?,
    val commitment: String?,
    val roadDifficulty: Int?) {

    data class Builder(
        var routeName: String? = null,
        var mountainName: String? = null,
        var isStandardRoute: Boolean? = null,
        var isSnowRoute: Boolean? = null,
        var grade: Int? = null,
        var trailhead: String? = null,
        var summitElevation: Int? = null,
        var gain: Int? = null,
        var length: Int? = null,
        var exposure: String? = null,
        var rockfallPotential: String? = null,
        var routeFinding: String? = null,
        var commitment: String? = null,
        var roadDifficulty: Int? = null
    ) {

        fun routeName(routeName: String) = apply { this.routeName = routeName }

        fun mountainName(mountainName: String) = apply { this.mountainName = mountainName }

        fun isStandardRoute(isStandardRoute: Boolean) = apply { this.isStandardRoute = isStandardRoute }

        fun isSnowRoute(isSnowRoute: Boolean) = apply { this.isSnowRoute = isSnowRoute }

        fun grade(grade: Int) = apply { this.grade = grade }

        fun trailhead(trailhead: String) = apply { this.trailhead = trailhead }

        fun summitElevation(summitElevation: Int) = apply { this.summitElevation = summitElevation }

        fun gain(gain: Int) = apply { this.gain = gain }

        fun length(length: Int) = apply { this.length = length }

        fun exposure(exposure: String) = apply { this.exposure = exposure }

        fun rockfallPotential(rockfallPotential: String) = apply { this.rockfallPotential = rockfallPotential }

        fun routeFinding(routeFinding: String) = apply { this.routeFinding = routeFinding}

        fun commitment(commitment: String) = apply { this.commitment = commitment }

        fun roadDifficulty(roadDifficulty: Int) = apply { this.roadDifficulty = roadDifficulty}

        fun build() = RoutesSearchCriteria(routeName, mountainName, isStandardRoute, isSnowRoute, grade, trailhead, summitElevation, gain, length, exposure, rockfallPotential, routeFinding, commitment, roadDifficulty)
    }
}
