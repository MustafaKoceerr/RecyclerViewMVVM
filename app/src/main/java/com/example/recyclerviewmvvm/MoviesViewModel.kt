package com.example.recyclerviewmvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewmvvm.model.Movie
import com.example.recyclerviewmvvm.model.Product
import kotlinx.coroutines.Job

class MoviesViewModel(
    private val repository: MoviesRepository
) : ViewModel() {

    private val _movies = MutableLiveData<List<Product>>()
    // you shouldn't expose Mutable live data out of the class

    val movies : LiveData<List<Product>>
        get() = _movies

    fun getMovies(){
        job = Coroutines.ioThenMain(
            { -> repository.getMoviesRepo()},

            { it: Movie? ->
                it?.let {movieee->
                    _movies.value = movieee.products
                    // if you try to do this thing in the IO thread, your
                    // app will crash, so thats why I did like this
                }
            }
        )
    }

    private lateinit var job: Job

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
        // Cancels the job to free up resources and prevent memory leaks
    }
    /*
    ChatGPT
    The onCleared function in the context of an Android ViewModel is used to clean up resources
    when the ViewModel is no longer needed and is about to be destroyed.
    This is a critical part of managing memory and resources efficiently in Android applications.
     */
}