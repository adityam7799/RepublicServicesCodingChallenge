package com.maddukuri.republicservices.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maddukuri.republicservices.data.DriverData

@Dao
interface DriverDao {

    // Define a suspend function to insert a list of drivers into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(drivers: List<DriverData>)

    // Define a query to retrieve all drivers from the "drivers" table
    @Query("SELECT * FROM drivers")
    fun getAllDrivers(): LiveData<List<DriverData>>
}