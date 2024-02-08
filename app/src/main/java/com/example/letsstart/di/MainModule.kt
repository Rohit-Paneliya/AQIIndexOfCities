package com.example.letsstart.di

import com.example.letsstart.network.NetworkApi
import com.example.letsstart.repository.MainRemoteRepository
import com.example.letsstart.repository.MainRemoteRepositoryImpl
import com.example.letsstart.usecase.MainUseCase
import com.example.letsstart.usecase.MainUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class MainModule {

    @Singleton
    @Provides
    fun provideMainRepository(networkApi: NetworkApi) : MainRemoteRepository {
        return MainRemoteRepositoryImpl(networkApi)
    }

    @Singleton
    @Provides
    fun provideMainUseCase(mainRemoteRepository: MainRemoteRepository) : MainUseCase {
        return MainUseCaseImpl(mainRemoteRepository)
    }
}