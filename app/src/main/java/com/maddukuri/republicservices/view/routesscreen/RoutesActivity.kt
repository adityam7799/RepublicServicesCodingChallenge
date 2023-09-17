package com.maddukuri.republicservices.view.routesscreen

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.maddukuri.republicservices.AppConstants.DRIVER_DETAILS
import com.maddukuri.republicservices.MainApplication
import com.maddukuri.republicservices.R
import com.maddukuri.republicservices.data.DriverData
import com.maddukuri.republicservices.databinding.ActivityRoutesBinding
import javax.inject.Inject

class RoutesActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: RoutesViewModel

    private lateinit var binding: ActivityRoutesBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding
        binding = ActivityRoutesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the title for the activity
        setTitle(R.string.route_screen_title)

        // Show the back button in the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Inject dependencies using Dagger
        (applicationContext as MainApplication).appComponent.inject(this)

        // Get driver details from intent
        val driverDetails =
            intent.extras?.getSerializable(DRIVER_DETAILS, DriverData::class.java)
        binding.textDriverName.text = driverDetails?.name

        // Observe route data and update UI
        viewModel.getRoutesLiveData().observe(this) { routeList ->
            driverDetails?.id?.toInt()?.let { driverId ->
                viewModel.getRoutesData(driverId, routeList)?.let { routeData ->
                    binding.textRouteNameValue.text = routeData.name
                    binding.textRouteTypeValue.text = routeData.type
                }
            }
        }
    }

    // Handle back button action for the action bar back button
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
