package com.example.letsstart.data.response

import androidx.annotation.ColorRes
import com.example.letsstart.R

data class AQIResponseItem(
    val aqi: Double,
    val city: String?,
    @ColorRes var backgroundColor: Int = R.color.white
)