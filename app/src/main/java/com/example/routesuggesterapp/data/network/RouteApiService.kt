package com.example.routesuggesterapp.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.POST

private const val BASE_URL = "a-url"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface RouteApiService {

    @POST("search")
    suspend fun getRoutesBySearchCriteria(body: RoutesSearchCriteria) : List<Route>

    @POST("search/suggest_by_weather")
    suspend fun getRoutesBySearchCriteriaAndWeather(body: RoutesSearchCriteria) : List<Route>

}

object RouteApi {
    val routeApiService : RouteApiService by lazy {
        retrofit.create(RouteApiService::class.java) }
}
