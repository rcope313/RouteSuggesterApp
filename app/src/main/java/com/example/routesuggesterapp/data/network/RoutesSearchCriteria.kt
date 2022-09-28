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
        private var grade: Pair<Int, Int>? = null,
        private var trailhead: String? = null,
        private var summitElevation: Pair<Int, Int>? = null,
        private var gain: Pair<Int, Int>? = null,
        private var length: Pair<Double, Double>? = null,
        private var exposure: List<String>? = null,
        private var rockfallPotential: List<String>? = null,
        private var routeFinding: List<String>? = null,
        private var commitment: List<String>? = null,
        private var roadDifficulty: Pair<Int, Int>? = null
    ) {

        fun applyCriteriaByChip(criteria: Criteria, checkedChips: List<String>) {
            apply {
                when (criteria) {
                    Criteria.EXPOSURE -> exposure = checkedChips
                    Criteria.ROCKFALL_POTENTIAL -> rockfallPotential = checkedChips
                    Criteria.ROUTE_FINDING -> routeFinding = checkedChips
                    Criteria.COMMITMENT -> commitment = checkedChips
                    else -> throw IllegalStateException("Not an instance of a chip view type")
                }
            }
        }

        fun applyCriteriaBySlider(criteria: Criteria, values: MutableList<Float>) {
            val valuesAsIntPair = Pair(values[0].toInt(), values[0].toInt())
            val valuesAsDoublePair = Pair(values[0].toDouble(), values[0].toDouble())
            apply {
                when (criteria) {
                    Criteria.GRADE -> grade = valuesAsIntPair
                    Criteria.SUMMIT_ELEVATION -> summitElevation = valuesAsIntPair
                    Criteria.GAIN -> gain = valuesAsIntPair
                    Criteria.LENGTH -> length = valuesAsDoublePair
                    Criteria.ROAD_DIFFICULTY -> roadDifficulty = valuesAsIntPair
                    else -> throw IllegalStateException("Not an instance of a slider view type")
                }
            }
        }

        fun applyCriteriaBySwitch(criteria: Criteria, isChecked: Boolean) {
            apply {
                when (criteria) {
                    Criteria.IS_STANDARD_ROUTE -> isStandardRoute = isChecked
                    Criteria.IS_SNOW_ROUTE -> isSnowRoute = isChecked
                    else -> throw IllegalStateException("Not an instance of a switch view type")
                }
            }
        }

        fun applyCriteriaByTextField(criteria: Criteria, text: String) {
            apply {
                when (criteria) {
                    Criteria.ROUTE_NAME -> routeName = text
                    Criteria.MOUNTAIN_NAME -> mountainName = text
                    Criteria.TRAILHEAD -> trailhead = text
                    else -> throw IllegalStateException("Not an instance of a text field view type")
                }
            }
        }

        fun build() = RoutesSearchCriteria(
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
            roadDifficulty
        )
    }
}

