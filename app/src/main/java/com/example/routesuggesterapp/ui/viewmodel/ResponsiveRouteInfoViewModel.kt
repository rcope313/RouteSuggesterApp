package com.example.routesuggesterapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.routesuggesterapp.data.repo.ResponsiveRouteInfo

class ResponsiveRouteInfoViewModel : ViewModel() {
    private val _routes = MutableLiveData<List<ResponsiveRouteInfo>>()
    val routes: LiveData<List<ResponsiveRouteInfo>> = _routes

}