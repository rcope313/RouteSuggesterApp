package com.example.routesuggesterapp.data.repo

import com.example.routesuggesterapp.data.db.FavoritedRouteDao
import com.example.routesuggesterapp.data.network.RouteInfoApi

class ResponsiveRouteInfoRepo(private val dao: FavoritedRouteDao, private val api: RouteInfoApi) {
}