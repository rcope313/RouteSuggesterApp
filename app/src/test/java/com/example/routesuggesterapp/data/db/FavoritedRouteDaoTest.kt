package com.example.routesuggesterapp.data.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class FavoritedRouteDaoTest {
    private lateinit var favoritedRouteDao: FavoritedRouteDao
    private lateinit var db: FavoritedRouteDatabase

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
}