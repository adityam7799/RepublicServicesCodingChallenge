package com.maddukuri.republicservices.network

import retrofit2.Response
import retrofit2.http.GET

// Retrofit interface for defining API endpoints and methods
interface RemoteAPI {

    // Define a GET request to fetch drivers data from the specified endpoint
    @GET("/data")
    suspend fun getDriversData(): Response<NetworkResponse>
}
