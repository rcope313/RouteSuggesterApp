package com.example.routesuggesterapp.data.network

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotSame
import org.junit.Before
import org.junit.Test

class RoutesSearchCriteriaTest {
    private lateinit var builder: RoutesSearchCriteria.Builder

    @Before
    fun initData() {
        builder = RoutesSearchCriteria.Builder()
    }

    @Test
    fun itCreatesAnImmutableRoutesSearchCriteria() {
        builder.exposure(listOf("high"))
        val criteria1 = builder.build()
        builder.exposure(listOf("high"))
        val criteria2 = builder.build()
        assertNotSame(criteria1, criteria2)
    }

    @Test
    fun itCanUpdateBuilderClassFieldWithMultipleGetFunctionCalls() {
        builder.exposure(listOf("high"))
        builder.exposure(listOf("low"))
        val criteria = builder.build()
        assertEquals(criteria.exposure, listOf("low"))
    }
}
