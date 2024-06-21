package com.example.recyclerviewmvvm

import com.example.recyclerviewmvvm.model.Movie

class MoviesRepository(
    private val api: MoviesApi
): SafeApiRequest() {

    suspend fun getMoviesRepo(): Movie {
        return safeApiRequest {
            api.getMovies()
        }
    }
}