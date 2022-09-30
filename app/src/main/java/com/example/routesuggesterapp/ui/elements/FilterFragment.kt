package com.example.routesuggesterapp.ui.elements

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.routesuggesterapp.data.network.RoutesSearchCriteria
import com.example.routesuggesterapp.databinding.FragmentFilterBinding
import com.example.routesuggesterapp.ui.adapter.FilterFragmentAdapter
import com.example.routesuggesterapp.ui.adapter.submitData
import com.example.routesuggesterapp.ui.adapter.models.FilterViewTypeList
import com.example.routesuggesterapp.ui.viewmodel.ResponsiveRouteViewModel
import com.google.android.material.divider.MaterialDividerItemDecoration
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "FilterFragment"

@AndroidEntryPoint
class FilterFragment : Fragment() {
    private lateinit var binding: FragmentFilterBinding
    private val viewModel: ResponsiveRouteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilterBinding.inflate(inflater, container, false)
        val adapter = FilterFragmentAdapter(RoutesSearchCriteria.Builder())
        adapter.dataSet = FilterViewTypeList.list
        binding.apply {
            val divider = MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
            recyclerView.addItemDecoration(divider)
            recyclerView.adapter = adapter
            recyclerView.submitData(FilterViewTypeList)
            Log.i(TAG, "Adapter for recyclerView = ${binding.recyclerView.adapter.toString()}")
        }
        return binding.root
    }
}