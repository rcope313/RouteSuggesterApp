package com.example.routesuggesterapp.data.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.emptyFlow
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class FavoritedRouteDaoTest {
    private lateinit var favoritedRouteDao: FavoritedRouteDao
    private lateinit var db: FavoritedRouteDatabase
    private val exampleFavoritedRoute = FavoritedRoute(routeId = 1)
    private val routeId = 1

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, FavoritedRouteDatabase::class.java).build()
        favoritedRouteDao = db.favoritedRouteDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    suspend fun itQueriesIntToFavoritedRoute() {
        favoritedRouteDao.insert(exampleFavoritedRoute)
        val result = favoritedRouteDao.getRouteId(routeId)
        assertEquals(result, exampleFavoritedRoute.routeId)
    }

    @Test
    suspend fun itQueriesIntToEmptyFlow() {
        favoritedRouteDao.insert(exampleFavoritedRoute)
        val result = favoritedRouteDao.getRouteId(2)
        assertEquals(result, emptyFlow<Int>())
    }
}