package com.maddukuri.republicservices.view.mainscreen

import com.maddukuri.republicservices.data.DriverData

// Interface for handling click events on drivers in the main screen
interface DriverClickHandler {
    // This method is called when a driver is clicked, and it provides the driver's details.
    fun driverClicked(driverDetails: DriverData)
}
