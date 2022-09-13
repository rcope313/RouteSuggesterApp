package com.example.routesuggesterapp.data.repo

import com.example.routesuggesterapp.data.db.FavoritedRoute
import com.example.routesuggesterapp.data.db.FavoritedRouteDao
import com.example.routesuggesterapp.data.network.Route
import com.example.routesuggesterapp.data.network.RouteApi
import com.example.routesuggesterapp.data.network.RoutesSearchCriteria
import kotlinx.coroutines.flow.single

class ResponsiveRouteRepo(private val dao: FavoritedRouteDao, private val api: RouteApi) {

    suspend fun getResponsiveRoutesBySearchCriteria(criteria: RoutesSearchCriteria) : List<ResponsiveRoute> {
        val routes = api.service.getRoutesBySearchCriteria(criteria)
        return buildListOfResponsiveRoutes(routes)
    }

    suspend fun getResponsiveRoutesBySearchCriteriaAndWeather(criteria: RoutesSearchCriteria) : List<ResponsiveRoute> {
        val routes = api.service.getRoutesBySearchCriteriaAndWeather(criteria)
        return buildListOfResponsiveRoutes(routes)
    }

    private suspend fun buildListOfResponsiveRoutes(routes: List<Route>) : List<ResponsiveRoute> {
        val listOfResponsiveRoutes = mutableListOf<ResponsiveRoute>()

        routes.forEach {
            if (isRouteFavorited(it)) {
                listOfResponsiveRoutes.add(ResponsiveRoute(true, it))
            } else {
                listOfResponsiveRoutes.add(ResponsiveRoute(false, it))
            }
        }
        return listOfResponsiveRoutes
    }

    //verify mockito
    private suspend fun favoriteRoute(route: Route) {
        dao.insert(FavoritedRoute(routeId = route.id))
    }

    //verify mockito
    private suspend fun unfavoriteRoute(route: Route) {
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