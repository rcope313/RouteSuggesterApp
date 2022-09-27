package com.example.routesuggesterapp.data.network

data class RoutesSearchCriteria private constructor (
    val routeName: String?,
    val mountainName: String?,
    val isStandardRoute: Boolean?,
    val isSnowRoute: Boolean?,
    val grade: Pair<Int,Int>?,
    val trailhead: String?,
    val summitElevation: Pair<Int,Int>?,
    val gain: Pair<Int,Int>?,
    val length: Pair<Double,Double>?,
    val exposure: List<String>?,
    val rockfallPotential: List<String>?,
    val routeFinding: List<String>?,
    val commitment: List<String>?,
    val roadDifficulty: Pair<Int,Int>?) {

    data class Builder(
        private var routeName: String? = null,
        private var mountainName: String? = null,
        private var isStandardRoute: Boolean? = null,
        private var isSnowRoute: Boolean? = null,
        private var grade: Pair<Int,Int>? = null,
        private var trailhead: String? = null,
        private var summitElevation: Pair<Int,Int>? = null,
        private var gain: Pair<Int,Int>? = null,
        private var length: Pair<Double,Double>? = null,
        private var exposure: List<String>? = null,
        private var rockfallPotential: List<String>? = null,
        private var routeFinding: List<String>? = null,
        private var commitment: List<String>? = null,
        private var roadDifficulty: Pair<Int,Int>? = null
    ) {

        fun routeName(routeName: String) = apply { this.routeName = routeName }

        fun mountainName(mountainName: String) = apply { this.mountainName = mountainName }

        fun isStandardRoute(isStandardRoute: Boolean) = apply { this.isStandardRoute = isStandardRoute }

        fun isSnowRoute(isSnowRoute: Boolean) = apply { this.isSnowRoute = isSnowRoute }

        fun grade(grade: Pair<Int,Int>) = apply { this.grade = grade }

        fun trailhead(trailhead: String) = apply { this.trailhead = trailhead }

        fun summitElevation(summitElevation: Pair<Int,Int>) = apply { this.summitElevation = summitElevation }

        fun gain(gain: Pair<Int,Int>) = apply { this.gain = gain }

        fun length(length: Pair<Double,Double>) = apply { this.length = length }

        fun exposure(exposure: List<String>) = apply { this.exposure = exposure }

        fun rockfallPotential(rockfallPotential: List<String>) = apply { this.rockfallPotential = rockfallPotential }

        fun routeFinding(routeFinding: List<String>) = apply { this.routeFinding = routeFinding}

        fun commitment(commitment: List<String>) = apply { this.commitment = commitment }

        fun roadDifficulty(roadDifficulty: Pair<Int,Int>) = apply { this.roadDifficulty = roadDifficulty}

        fun build() = RoutesSearchCriteria(routeName, mountainName, isStandardRoute, isSnowRoute, grade, trailhead, summitElevation, gain, length, exposure, rockfallPotential, routeFinding, commitment, roadDifficulty)
    }
}
