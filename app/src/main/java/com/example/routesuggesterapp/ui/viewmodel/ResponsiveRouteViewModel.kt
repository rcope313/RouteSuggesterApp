package com.example.routesuggesterapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.routesuggesterapp.data.repo.ResponsiveRoute
import com.example.routesuggesterapp.data.repo.ResponsiveRouteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResponsiveRouteViewModel @Inject constructor(
    private val repo: ResponsiveRouteRepo
) : ViewModel() {
    private val _routes = MutableLiveData<List<ResponsiveRoute>>()
    val routes: LiveData<List<ResponsiveRoute>> = _routes

}