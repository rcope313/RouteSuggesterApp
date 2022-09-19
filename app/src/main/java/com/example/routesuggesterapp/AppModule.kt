package com.example.routesuggesterapp

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.routesuggesterapp.data.db.FavoritedRouteDao
import com.example.routesuggesterapp.data.db.FavoritedRouteDatabase
import com.example.routesuggesterapp.data.network.RouteApiService
import com.example.routesuggesterapp.data.repo.ResponsiveRouteRepo
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(Application::class)
object AppModule {
    private const val BASE_URL = "https://restcountries.eu/rest/v2/"

    @Singleton
    @Provides
    fun providesMoshi() : Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)


    @Singleton
    @Provides
    fun provideRetrofit(moshiConverterFactory: MoshiConverterFactory): Retrofit =
        Retrofit.Builder()
        .addConverterFactory(moshiConverterFactory)
        .baseUrl(BASE_URL)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): RouteApiService =
        retrofit.create(RouteApiService::class.java)

    @Singleton
    @Provides
    fun provideFavoritedRouteDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(
        app,
        FavoritedRouteDatabase::class.java,
        "your_db_name"
    ).build()

    @Singleton
    @Provides
    fun provideFavoritedRouteDao(db: FavoritedRouteDatabase) =
        db.favoritedRouteDao()

    @Singleton
    @Provides
    fun providesResponsiveRouteRepo(dao: FavoritedRouteDao, apiService: RouteApiService) =
        ResponsiveRouteRepo(dao, apiService)
}
