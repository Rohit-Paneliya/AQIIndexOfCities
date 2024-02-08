package com.example.letsstart.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.letsstart.data.response.AQIResponseItem
import com.example.letsstart.databinding.ItemCityWithAqiBinding

class CityListAdapter(private val cityList: List<AQIResponseItem>) :
    RecyclerView.Adapter<CityListAdapter.CityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view =
            ItemCityWithAqiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) =
        holder.bind(cityList[position])

    override fun getItemCount() = cityList.size

    inner class CityViewHolder(private val itemBinding: ItemCityWithAqiBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: AQIResponseItem) {
            with(itemBinding) {
                itemBinding.root.setBackgroundColor(
                    ContextCompat.getColor(
                        itemBinding.root.context,
                        item.backgroundColor
                    )
                )
                cityNameTextView.text = item.city
                aqiInfoTextView.text = item.aqi.toString()
            }
        }
    }
}