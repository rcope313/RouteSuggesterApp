package com.example.routesuggesterapp.ui.elements

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.routesuggesterapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}