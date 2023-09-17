package com.maddukuri.republicservices.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

// Define a Room Entity for drivers with a specified table name
@Entity(tableName = "drivers")
data class DriverData(
    // Primary key for the driver data
    @PrimaryKey
    @SerializedName("id")
    val id: String,

    // Driver's name
    @SerializedName("name")
    val name: String
) : Serializable
