package com.example.letsstart.usecase

import com.example.letsstart.data.response.AQIResponse
import retrofit2.Response

interface MainUseCase {

    suspend fun getAllCitiesInfoWithAQI(): AQIResponse
}
