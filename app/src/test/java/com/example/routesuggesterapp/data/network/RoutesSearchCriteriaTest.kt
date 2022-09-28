package com.example.routesuggesterapp.data.network

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotSame
import org.junit.Before
import org.junit.Test
import java.lang.IllegalStateException

class RoutesSearchCriteriaTest {
    private lateinit var builder: RoutesSearchCriteria.Builder

    @Before
    fun initData() {
        builder = RoutesSearchCriteria.Builder()
    }

    @Test
    fun itCreatesAnImmutableRoutesSearchCriteria() {
        builder.applyCriteriaByChip(Criteria.EXPOSURE, listOf("high"))
        val criteria1 = builder.build()
        builder.applyCriteriaByChip(Criteria.EXPOSURE, listOf("high"))
        val criteria2 = builder.build()
        assertNotSame(criteria1, criteria2)
    }

    @Test
    fun itCanUpdateBuilderClassFieldWithMultipleGetFunctionCalls() {
        builder.applyCriteriaByChip(Criteria.EXPOSURE, listOf("high"))
        builder.applyCriteriaByChip(Criteria.EXPOSURE, listOf("high", "low"))
        val criteria = builder.build()
        assertEquals(criteria.exposure, listOf("high", "low"))
    }

    @Test(expected = IllegalStateException::class)
    fun itThrowsIllegalStateExceptionWhenProvidedWrongCriteriaByChip() {
        builder.applyCriteriaByChip(Criteria.ROUTE_NAME, listOf("low"))
    }

    @Test(expected = IllegalStateException::class)
    fun itThrowsIllegalStateExceptionWhenProvidedWrongCriteriaBySlider() {
        java.lang.Float(100.0)
        builder.applyCriteriaBySlider(Criteria.ROUTE_NAME, mutableListOf(1f, 2f))
    }

    @Test(expected = IllegalStateException::class)
    fun itThrowsIllegalStateExceptionWhenProvidedWrongCriteriaBySwitch() {
        builder.applyCriteriaBySwitch(Criteria.ROUTE_NAME, false)
    }

    @Test(expected = IllegalStateException::class)
    fun itThrowsIllegalStateExceptionWhenProvidedWrongCriteriaByTextField() {
        builder.applyCriteriaByTextField(Criteria.EXPOSURE, "Long's Peak")
    }
}
