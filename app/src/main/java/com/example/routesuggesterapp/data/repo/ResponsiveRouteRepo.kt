package com.example.routesuggesterapp.data.repo

import com.example.routesuggesterapp.data.db.FavoritedRoute
import com.example.routesuggesterapp.data.db.FavoritedRouteDao
import com.example.routesuggesterapp.data.network.Route
import com.example.routesuggesterapp.data.network.RouteApi
import com.example.routesuggesterapp.data.network.RoutesSearchCriteria
import kotlinx.coroutines.flow.single

class ResponsiveRouteRepo(
    private val dao: FavoritedRouteDao,
    private val api: RouteApi
    )
{
    suspend fun getResponsiveRoutesBySearchCriteria(criteria: RoutesSearchCriteria) : List<ResponsiveRoute> {
        val routes = api.routeApiService.getRoutesBySearchCriteria(criteria)
        val listOfResponsiveRoutes = mutableListOf<ResponsiveRoute>()

        routes.forEach {
            when (isRouteFavorited(it)) {
                listOfResponsiveRoutes.add(ResponsiveRoute(true, it))
                else -> listOfResponsiveRoutes.add(ResponsiveRoute(false, it))
            }
        }
        return listOfResponsiveRoutes
    }

    suspend fun getResponsiveRoutesBySearchCriteriaAndWeather(criteria: RoutesSearchCriteria) : List<ResponsiveRoute> {
        val routes = api.routeApiService.getRoutesBySearchCriteriaAndWeather(criteria)
        val listOfResponsiveRoutes = mutableListOf<ResponsiveRoute>()

        routes.forEach {
            when (isRouteFavorited(it)) {
                listOfResponsiveRoutes.add(ResponsiveRoute(true, it))
                else -> listOfResponsiveRoutes.add(ResponsiveRoute(false, it))
            }
        }
        return listOfResponsiveRoutes
    }

    suspend fun favoriteRoute(route: Route) {
        dao.insert(FavoritedRoute(routeId = route.id))
    }

    suspend fun unfavoriteRoute(route: Route) {
        dao.delete(FavoritedRoute(routeId = route.id))
    }

    private suspend fun isRouteFavorited(route: Route) : Boolean {
        return try {
            dao.getRouteId(route.id).single()
            true
        } catch (e: NoSuchElementException ) {
            false
        }
    }

}