package com.example.recyclerviewmvvm.data.network

import com.example.recyclerviewmvvm.data.model.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MoviesApi {

    @GET("products")
    suspend fun getMovies(): Response<Movie>






    companion object {
        const val BASE_URL = "https://dummyjson.com/"
        operator fun invoke(): MoviesApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(MoviesApi::class.java)
        }
        // That means when you write MoviesApi(),
        // you call the invoke function.
    }
}