package com.maddukuri.republicservices.data.source.local

import androidx.lifecycle.LiveData
import com.maddukuri.republicservices.data.DriverData
import com.maddukuri.republicservices.data.RouteData
import com.maddukuri.republicservices.network.NetworkResponse

// Repository for handling local data operations
interface LocalDataRepository {

    // Insert network data into the local database
    suspend fun insertNetworkData(networkResponse: NetworkResponse)

    // Get LiveData of drivers' data from the local database
    suspend fun getDriversData(): LiveData<List<DriverData>>

    // Get LiveData of routes' data from the local database
    suspend fun getRoutesData(): LiveData<List<RouteData>>
}
