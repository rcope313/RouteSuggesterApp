package com.example.routesuggesterapp.data.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.Event
import app.cash.turbine.test
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class FavoritedRouteDaoTest {
    private lateinit var favoritedRouteDao: FavoritedRouteDao
    private lateinit var db: FavoritedRouteDatabase
    private val exampleFavoritedRoute = FavoritedRoute(routeId = 1)

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, FavoritedRouteDatabase::class.java
        ).build()
        favoritedRouteDao = db.favoritedRouteDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun itQueriesIntToFavoritedRoute() = runTest {
        favoritedRouteDao.insert(exampleFavoritedRoute)
        val collectJob = launch(UnconfinedTestDispatcher()) {
            favoritedRouteDao.getRouteId(1).test {
                assertEquals(awaitItem(), 1);
                ensureAllEventsConsumed()
            }
        }
        collectJob.cancel()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun itQueriesIntToEmptyFlow() = runTest {
        favoritedRouteDao.insert(exampleFavoritedRoute)
        val collectJob = launch(UnconfinedTestDispatcher()) {
            favoritedRouteDao.getRouteId(2).test {
                ensureAllEventsConsumed()
            }
        }
        collectJob.cancel()
    }
}
