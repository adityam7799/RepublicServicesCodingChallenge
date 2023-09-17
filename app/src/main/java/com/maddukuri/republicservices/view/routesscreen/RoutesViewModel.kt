package com.maddukuri.republicservices.view.routesscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.maddukuri.republicservices.data.RouteData
import com.maddukuri.republicservices.data.source.local.LocalDataRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class RoutesViewModel @Inject constructor(private val localDataRepository: LocalDataRepository) :
    ViewModel() {

    // Function to get LiveData for routes data
    fun getRoutesLiveData(): LiveData<List<RouteData>> {
        return liveData(Dispatchers.IO) {
            emitSource(localDataRepository.getRoutesData())
        }
    }

    // Function to get route data based on driver details
    fun getRoutesData(driverId: Int, routeList: List<RouteData>): RouteData? {
        val matchingRoute = routeList.firstOrNull { it.id == driverId }
        return when {
            matchingRoute != null -> matchingRoute
            driverId % 2 == 0 -> routeList.firstOrNull { it.type == "R" }
            driverId % 5 == 0 -> routeList.filter { it.type == "C" }.getOrNull(1)
            else -> routeList.lastOrNull { it.type == "I" }
        }
    }
}
