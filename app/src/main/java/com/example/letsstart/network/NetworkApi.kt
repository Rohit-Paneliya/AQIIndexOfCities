package com.example.letsstart.network

import com.example.letsstart.data.response.AQIResponse
import com.example.letsstart.data.response.MainResponse
import retrofit2.Response
import retrofit2.http.GET

interface NetworkApi {

    @GET
    suspend fun getAllCitiesWithAQI() : Response<AQIResponse>
}