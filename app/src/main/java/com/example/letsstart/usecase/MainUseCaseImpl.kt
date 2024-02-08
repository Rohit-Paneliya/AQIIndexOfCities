package com.example.letsstart.usecase

import com.example.letsstart.data.response.AQIResponse
import com.example.letsstart.repository.MainRemoteRepository
import retrofit2.Response
import javax.inject.Inject

class MainUseCaseImpl @Inject constructor(private val mainRemoteRepository: MainRemoteRepository): MainUseCase {

    override suspend fun getAllCitiesInfoWithAQI(): AQIResponse {
        return mainRemoteRepository.getAllCitiesInfoWithAQI()
    }
}