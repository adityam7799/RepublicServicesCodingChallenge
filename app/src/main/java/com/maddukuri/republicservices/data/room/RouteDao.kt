package com.maddukuri.republicservices.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maddukuri.republicservices.data.RouteData

@Dao
interface RouteDao {

    // Define a suspend function to insert a list of routes into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(routes: List<RouteData>)

    // Define a query to retrieve all routes from the "routes" table
    @Query("SELECT * FROM routes")
    fun getAllRoutes(): LiveData<List<RouteData>>
}
