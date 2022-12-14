package com.example.routesuggesterapp.data.repo

import com.example.routesuggesterapp.data.db.FavoritedRoute
import com.example.routesuggesterapp.data.db.FavoritedRouteDao
import com.example.routesuggesterapp.data.network.Route
import com.example.routesuggesterapp.data.network.RouteApiService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class ResponsiveRouteRepoTest {
    private lateinit var dao: FavoritedRouteDao
    private lateinit var apiService: RouteApiService
    private lateinit var repo: ResponsiveRouteRepo
    private lateinit var keyHoleRoute: Route
    private lateinit var loftRoute: Route
    private lateinit var keyHoleRouteFavorited: ResponsiveRoute
    private lateinit var loftRouteNotFavorited: ResponsiveRoute

    @Before
    fun initData() {
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

        dao = mock()
        apiService = mock()
        repo = ResponsiveRouteRepo(dao, apiService)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun itBuildsAnEmptyListOfResponsiveRoutes() = runTest {
        assertEquals(
            repo.buildListOfResponsiveRoutes(listOf()),
            listOf<ResponsiveRoute>()
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun itBuildsAListOfResponsiveRoutes() = runTest {
        whenever(dao.getRouteId(keyHoleRoute.id)) doReturn flow {
            emit(keyHoleRoute.id)
        }
        whenever(dao.getRouteId(loftRoute.id)) doReturn emptyFlow()

        assertEquals(
            repo.buildListOfResponsiveRoutes(listOf(keyHoleRoute, loftRoute)),
            listOf(keyHoleRouteFavorited, loftRouteNotFavorited)
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun itFavoritesRouteByDao() = runTest{
        repo.favoriteRoute(keyHoleRoute)
        verify(dao).insert(FavoritedRoute(routeId = keyHoleRoute.id))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun itUnFavoritesRouteByDao() = runTest {
        repo.unfavoriteRoute(keyHoleRoute)
        verify(dao).delete(FavoritedRoute(routeId = keyHoleRoute.id))
    }
}
