package com.example.letsstart.util

import com.example.letsstart.R
import com.example.letsstart.data.response.AQIResponseItem

object AppConstants {

    const val sampleResponse = """[
                          {
                            "city": "Mumbai",
                            "aqi": 45.23145
                          },
                          {
                            "city": "Delhi",
                            "aqi": 129.23145
                          },
                          {
                            "city": "Chennai",
                            "aqi": 168.23145
                          },
                          {
                            "city": "Pune",
                            "aqi": 225.23145
                          },                         
                          {
                            "city": "Nagpur",
                            "aqi": 355.23145
                          }
                        ]"""


    // Extension function to return the citi list with respected color range.
    fun List<AQIResponseItem>.getAQIColorBasedOnIndex(): List<AQIResponseItem> {
        return this.map {
            it.backgroundColor = when (it.aqi) {
                in 0.0..50.0 -> { //green
                    R.color.green
                }

                in 51.01..100.0 -> { // yellow
                    R.color.yellow
                }

                in 100.01..150.0 -> { // orange
                    R.color.orange
                }

                in 151.01..200.0 -> { // red
                    R.color.red
                }

                in 201.01..300.0 -> { // purple
                    R.color.purple
                }

                // >300
                else -> {  // maroon
                    R.color.maroon
                }
            }
            it
        }
    }
}