package com.example.routesuggesterapp.data.network

import retrofit2.http.POST

interface RouteApiService {

    @POST("search")
    suspend fun getRoutesBySearchCriteria(body: RoutesSearchCriteria) : List<Route>

    @POST("search/suggest_by_weather")
    suspend fun getRoutesBySearchCriteriaAndWeather(criteria: RoutesSearchCriteria) : List<Route>

}
