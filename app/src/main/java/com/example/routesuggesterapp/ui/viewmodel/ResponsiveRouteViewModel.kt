package com.example.routesuggesterapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.routesuggesterapp.data.repo.ResponsiveRoute

class ResponsiveRouteViewModel : ViewModel() {
    private val _routes = MutableLiveData<List<ResponsiveRoute>>()
    val routes: LiveData<List<ResponsiveRoute>> = _routes

}