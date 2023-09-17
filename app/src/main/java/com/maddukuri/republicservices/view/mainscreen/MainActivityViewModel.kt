package com.maddukuri.republicservices.view.mainscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.maddukuri.republicservices.data.DriverData
import com.maddukuri.republicservices.data.source.local.LocalDataRepository
import com.maddukuri.republicservices.data.source.remote.RemoteDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val localDataRepository: LocalDataRepository,
    private val remoteDataRepository: RemoteDataRepository
) : ViewModel() {

    // LiveData to hold the list of driver data
    private val _driverListLiveData = getDriversData()
    val driverListLiveData: LiveData<List<DriverData>>
        get() = _driverListLiveData

    // Function to fetch driver and route data
    fun fetchRemoteDriverData() =
        viewModelScope.launch {
            remoteDataRepository.getRemoteData()
        }

    // Function to fetch drivers data from Local Database
    private fun getDriversData(): MutableLiveData<List<DriverData>> = liveData(Dispatchers.IO) {
        emitSource(localDataRepository.getDriversData())
    } as MutableLiveData<List<DriverData>>

    // Function to get a sorted list of drivers based on last name
    fun getSortedDriversList() {
        _driverListLiveData.postValue(_driverListLiveData.value?.sortedBy {
            it.name.split(" ").last()
        })
    }
}
