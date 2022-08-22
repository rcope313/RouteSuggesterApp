package com.example.routesuggesterapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoritedRoute::class], version = 1, exportSchema = false)
abstract class FavoritedRouteDatabase : RoomDatabase() {

    abstract fun favoritedRouteDao(): FavoritedRouteDao

    companion object {
        @Volatile
        private var INSTANCE: FavoritedRouteDatabase? = null

        fun getDatabase(context: Context): FavoritedRouteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavoritedRouteDatabase::class.java,
                    "item_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}