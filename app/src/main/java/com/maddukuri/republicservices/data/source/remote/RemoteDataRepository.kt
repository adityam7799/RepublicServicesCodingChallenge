package com.maddukuri.republicservices.data.source.remote

// Repository for handling remote data operations
interface RemoteDataRepository {

    // Define a method to fetch and process data from a remote source
    suspend fun getRemoteData()
}
