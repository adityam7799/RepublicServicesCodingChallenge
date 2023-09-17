package com.maddukuri.republicservices.data.source.local

import androidx.lifecycle.LiveData
import com.maddukuri.republicservices.data.room.AppDatabase
import com.maddukuri.republicservices.data.DriverData
import com.maddukuri.republicservices.data.RouteData
import com.maddukuri.republicservices.network.NetworkResponse
import javax.inject.Inject

// Repository for handling local data operations
class DefaultLocalDataRepository @Inject constructor(private val appDatabase: AppDatabase) :
    LocalDataRepository {

    // Insert network data into the local database
    override suspend fun insertNetworkData(networkResponse: NetworkResponse) {
        appDatabase.driverDao().insertAll(networkResponse.driversList)
        appDatabase.routeDao().insertAll(networkResponse.routeList)
    }

    // Get LiveData of drivers data from the local database
    override suspend fun getDriversData(): LiveData<List<DriverData>> =
        appDatabase.driverDao().getAllDrivers()

    // Get LiveData of routes data from the local database
    override suspend fun getRoutesData(): LiveData<List<RouteData>> =
        appDatabase.routeDao().getAllRoutes()
}
