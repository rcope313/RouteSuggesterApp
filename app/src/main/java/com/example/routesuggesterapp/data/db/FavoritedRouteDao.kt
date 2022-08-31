package com.example.routesuggesterapp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritedRouteDao {

    @Query("SELECT routeId from FavoritedRoute WHERE id = :id")
    fun getRouteId(id: Int): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favoritedRoute: FavoritedRoute)

    @Delete
    suspend fun delete(favoritedRoute: FavoritedRoute)
}
