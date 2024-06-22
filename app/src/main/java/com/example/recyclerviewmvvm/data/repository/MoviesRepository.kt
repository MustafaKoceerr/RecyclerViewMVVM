package com.example.recyclerviewmvvm.data.repository

import com.example.recyclerviewmvvm.data.model.Movie
import com.example.recyclerviewmvvm.data.network.MoviesApi
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    // but in case of AuthApi it is not possible to constructor inject
    //because ***AuthApi is an interface***
    private val api: MoviesApi
): SafeApiRequest() {

    suspend fun getMoviesRepo(): Movie {
        return safeApiRequest {
            api.getMovies()
        }
    }
}