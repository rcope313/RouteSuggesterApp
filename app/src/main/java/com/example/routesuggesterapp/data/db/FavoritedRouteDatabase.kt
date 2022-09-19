package com.example.routesuggesterapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoritedRoute::class], version = 1, exportSchema = false)
abstract class FavoritedRouteDatabase : RoomDatabase() {

    abstract fun favoritedRouteDao(): FavoritedRouteDao

}