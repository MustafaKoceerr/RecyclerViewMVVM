package com.example.recyclerviewmvvm.data.repository

import com.example.recyclerviewmvvm.data.model.Movie
import com.example.recyclerviewmvvm.data.network.MoviesApi

class MoviesRepository(
    private val api: MoviesApi
): SafeApiRequest() {

    suspend fun getMoviesRepo(): Movie {
        return safeApiRequest {
            api.getMovies()
        }
    }
}