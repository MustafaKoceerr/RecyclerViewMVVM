package com.example.recyclerviewmvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmvvm.databinding.RecyclerviewMovieBinding
import com.example.recyclerviewmvvm.model.Product

class MoviesAdapter(
    private val movies : List<Product>
) :RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    inner class MoviesViewHolder(
        val recyclerViewMovieBinding : RecyclerviewMovieBinding
    ): RecyclerView.ViewHolder(recyclerViewMovieBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        // Gördüğün gibi bu fonksiyonda MoviesViewHolder döndürmen gerekiyor, üstteki viewholder sınıfına bakarsan da
        //         val recyclerViewMovieBinding : RecyclerviewMovieBinding parametresini alıyor.
        return MoviesViewHolder(
            DataBindingUtil.inflate<RecyclerviewMovieBinding>(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_movie,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

        holder.recyclerViewMovieBinding.movie = movies.get(position)
        // buradaki movie Layout'ta data kısmında koyduğumuz parametre ismi olan movie'dir.

    }


}