package com.maddukuri.republicservices.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maddukuri.republicservices.data.DriverData
import com.maddukuri.republicservices.data.RouteData

// Define a Room database with the specified entities and version
@Database(entities = [DriverData::class, RouteData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    // Provide an abstract function to access the DriverDao
    abstract fun driverDao(): DriverDao

    // Provide an abstract function to access the RouteDao
    abstract fun routeDao(): RouteDao
}
