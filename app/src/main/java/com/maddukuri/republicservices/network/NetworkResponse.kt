package com.maddukuri.republicservices.network

import com.google.gson.annotations.SerializedName
import com.maddukuri.republicservices.data.DriverData
import com.maddukuri.republicservices.data.RouteData

// Represents the response received from the network API
class NetworkResponse(
    // List of driver data received from the API
    @SerializedName("drivers")
    val driversList: List<DriverData>,

    // List of route data received from the API
    @SerializedName("routes")
    val routeList: List<RouteData>
)
