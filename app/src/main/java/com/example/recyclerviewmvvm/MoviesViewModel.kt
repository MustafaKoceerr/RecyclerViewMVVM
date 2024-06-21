package com.example.recyclerviewmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewmvvm.model.Movie

class MoviesViewModel(
    private val repository: MoviesRepository
) : ViewModel() {

    private val _movies = MutableLiveData<Movie>()
    // you shouldn't expose Mutable live data out of the class

    val movies : LiveData<Movie>
        get() = _movies

    suspend fun getMovies(){
        val movies = repository.getMoviesRepo()
        _movies.value = movies
    }
}