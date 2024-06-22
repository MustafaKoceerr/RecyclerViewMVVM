package com.example.recyclerviewmvvm.di

import com.example.recyclerviewmvvm.data.model.Movie
import com.example.recyclerviewmvvm.data.network.MoviesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
// We will use this model for tell hilt that how to build this AuthAPi

    // Now here we need to tell hilt that how to construct AuthApi.
    @Singleton
    @Provides
    fun provideMoviesApi(): MoviesApi{
        return MoviesApi.invoke()
    }





}