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
        builder.exposure("high")
        val criteria1 = builder.build()
        builder.exposure("high")
        val criteria2 = builder.build()
        assertNotSame(criteria1, criteria2)
    }

    @Test
    fun itCanUpdateBuilderClassFieldWithMultipleGetFunctionCalls() {
        builder.exposure("high")
        builder.exposure("low")
        val criteria = builder.build()
        assertEquals(criteria.exposure, "low")
    }
}
