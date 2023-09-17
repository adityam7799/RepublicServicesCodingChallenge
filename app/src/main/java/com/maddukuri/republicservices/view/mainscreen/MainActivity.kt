package com.maddukuri.republicservices.view.mainscreen

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.maddukuri.republicservices.AppConstants.DRIVER_DETAILS
import com.maddukuri.republicservices.MainApplication
import com.maddukuri.republicservices.R
import com.maddukuri.republicservices.data.DriverData
import com.maddukuri.republicservices.databinding.ActivityMainBinding
import com.maddukuri.republicservices.view.routesscreen.RoutesActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), DriverClickHandler {

    @Inject
    lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflating the layout using ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inject dependencies using Dagger
        (applicationContext as MainApplication).appComponent.inject(this)


        binding.recyclerDriversList.layoutManager = LinearLayoutManager(this)

        // Set the title for the activity
        setTitle(R.string.driver_screen_title)

        // Fetch remote driver data using the ViewModel
        viewModel.fetchRemoteDriverData()

        // Observe changes in the driver list and update the RecyclerView
        viewModel.driverListLiveData.observe(this) { driverList ->
            binding.recyclerDriversList.adapter = DriversAdapter(driverList, this)
        }
    }

    // Handle driver item click by navigating to RoutesActivity
    override fun driverClicked(driverDetails: DriverData) {
        val intent = Intent(this, RoutesActivity::class.java)
        intent.putExtra(DRIVER_DETAILS, driverDetails)
        startActivity(intent)
    }

    // Create the options menu to add sort icon to the top right
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        menu?.findItem(R.id.action_sort)?.actionView?.setOnClickListener {
            viewModel.getSortedDriversList()
        }
        return true
    }
}
