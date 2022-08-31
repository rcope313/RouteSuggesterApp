package com.example.routesuggesterapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoritedRoute (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val routeId: Int,
)
