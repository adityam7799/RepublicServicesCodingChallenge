package com.maddukuri.republicservices.data.source.remote

import com.maddukuri.republicservices.data.source.local.LocalDataRepository
import com.maddukuri.republicservices.network.RemoteAPI
import javax.inject.Inject

// Repository for handling remote data operations
class DefaultRemoteDataRepository @Inject constructor(
    private val localDataRepository: LocalDataRepository,
    private val remoteAPI: RemoteAPI
) : RemoteDataRepository {

    // Fetch data from the remote API and insert it into the local database
    override suspend fun getRemoteData() {
        // Make a network request to get drivers data from the remote API
        remoteAPI.getDriversData().body()?.let { networkResponse ->
            // Insert the network data into the local database
            localDataRepository.insertNetworkData(networkResponse)
        }
    }
}
