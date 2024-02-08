package com.example.letsstart.repository

import com.example.letsstart.data.response.AQIResponse
import retrofit2.Response

interface MainRemoteRepository {

    suspend fun getAllCitiesInfoWithAQI(): AQIResponse
}