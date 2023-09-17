package com.maddukuri.republicservices.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

// Define a Room Entity for routes with a specified table name
@Entity(tableName = "routes")
data class RouteData(
    // Primary key for the route data
    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    // Type of the route
    @SerializedName("type")
    val type: String,

    // Name of the route
    @SerializedName("name")
    val name: String
) : Serializable
