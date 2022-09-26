package com.example.routesuggesterapp.data.network

data class RoutesSearchCriteria private constructor (
    val routeName: String?,
    val mountainName: String?,
    val isStandardRoute: Boolean?,
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
        private var routeName: String? = null,
        private var mountainName: String? = null,
        private var isStandardRoute: Boolean? = null,
        private var isSnowRoute: Boolean? = null,
        private var grade: Int? = null,
        private var trailhead: String? = null,
        private var summitElevation: Int? = null,
        private var gain: Int? = null,
        private var length: Int? = null,
        private var exposure: String? = null,
        private var rockfallPotential: String? = null,
        private var routeFinding: String? = null,
        private var commitment: String? = null,
        private var roadDifficulty: Int? = null
    ) {

        fun routeName(routeName: String) = apply {
            this.routeName = routeName
        }

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
