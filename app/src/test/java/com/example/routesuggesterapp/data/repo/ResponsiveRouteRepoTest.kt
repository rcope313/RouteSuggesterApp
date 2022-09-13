package com.example.routesuggesterapp.data.repo

import com.example.routesuggesterapp.data.db.FavoritedRouteDao
import com.example.routesuggesterapp.data.network.Route
import com.example.routesuggesterapp.data.network.RouteApi
import com.example.routesuggesterapp.data.network.RouteApi.service
import com.example.routesuggesterapp.data.network.RouteApiService
import com.example.routesuggesterapp.data.network.RoutesSearchCriteria
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

class ResponsiveRouteRepoTest {
    private lateinit var dao: FavoritedRouteDao
    private lateinit var api: RouteApiService
    private lateinit var repo: ResponsiveRouteRepo
    private lateinit var longsPeakCriteria: RoutesSearchCriteria
    private lateinit var keyHoleRoute: Route
    private lateinit var loftRoute: Route
    private lateinit var keyHoleRouteFavorited: ResponsiveRoute
    private lateinit var loftRouteNotFavorited: ResponsiveRoute

    @Before
    fun initData() {
        longsPeakCriteria = RoutesSearchCriteria(
            Optional.empty(),
            Optional.of("Longs Peak"),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty()
        )

        keyHoleRoute = Route(
            1,
            "Keyhole Route",
            "Longs Peak",
            true,
            false,
            3,
            "Longs Peak Trailhead",
            14256,
            5100,
            14,
            "high",
            "considerable",
            "considerable",
            "high",
            1,
            "thekeyholerouteiscool.com",
            "longspeaktrailheadisgreat.com"
        )
        loftRoute = Route(
            2,
            "Loft Route",
            "Longs Peak",
            false,
            false,
            3,
            "Longs Peak Trailhead",
            14256,
            5300,
            13,
            "high",
            "considerable",
            "high",
            "high",
            1,
            "theloftrouteisfine.com",
            "longspeaktrailheadisgreat.com"
        )
        keyHoleRouteFavorited = ResponsiveRoute(true, keyHoleRoute)
        loftRouteNotFavorited = ResponsiveRoute(false, loftRoute)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun itGetsResponsiveRoutesBySearchCriteria() = runTest {
        api = mock()
        whenever(service.getRoutesBySearchCriteria(longsPeakCriteria)) doReturn listOf()
        whenever(service.getRoutesBySearchCriteriaAndWeather(longsPeakCriteria)) doReturn listOf()

        dao = mock()
        whenever(dao.getRouteId(keyHoleRoute.id)) doReturn flow {
            emit(keyHoleRoute.id)
        }
        whenever(dao.getRouteId(loftRoute.id)) doReturn emptyFlow()

        repo = ResponsiveRouteRepo(dao, RouteApi)
        assertEquals(
            repo.getResponsiveRoutesBySearchCriteria(longsPeakCriteria),
            listOf(keyHoleRouteFavorited, loftRouteNotFavorited)
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun itGetsResponsiveRoutesBySearchCriteriaAndWeather() = runTest {
    }
}