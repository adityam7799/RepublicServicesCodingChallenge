package com.maddukuri.republicservices.view.mainscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maddukuri.republicservices.data.DriverData
import com.maddukuri.republicservices.databinding.DriverItemBinding

// Adapter for displaying drivers in a RecyclerView using ViewBinding
class DriversAdapter(
    private val driverList: List<DriverData>,
    private val driverClickHandler: DriverClickHandler
) : RecyclerView.Adapter<DriversAdapter.ViewHolder>() {

    // Create a ViewHolder for each item view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DriverItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // Bind data to the ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(driverList[position])

    // Return the number of items in the list
    override fun getItemCount(): Int = driverList.size

    // ViewHolder class that holds views for each driver item
    inner class ViewHolder(private val binding: DriverItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(driver: DriverData) {
            binding.textDriverName.text = driver.name
            binding.root.setOnClickListener {
                driverClickHandler.driverClicked(driver)
            }
        }
    }
}
