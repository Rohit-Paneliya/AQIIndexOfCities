package com.example.letsstart.repository

import com.example.letsstart.data.response.AQIResponse
import com.example.letsstart.network.NetworkApi
import com.example.letsstart.util.AppConstants
import com.google.gson.Gson
import retrofit2.Response
import javax.inject.Inject

class MainRemoteRepositoryImpl @Inject constructor(private val networkApi: NetworkApi): MainRemoteRepository {

    override suspend fun getAllCitiesInfoWithAQI(): AQIResponse {
        return Gson().fromJson(AppConstants.sampleResponse, AQIResponse::class.java)
    }
}