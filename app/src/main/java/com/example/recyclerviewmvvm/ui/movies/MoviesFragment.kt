package com.example.recyclerviewmvvm.ui.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewmvvm.R
import com.example.recyclerviewmvvm.data.model.Product
import com.example.recyclerviewmvvm.data.network.MoviesApi
import com.example.recyclerviewmvvm.data.repository.MoviesRepository
import com.example.recyclerviewmvvm.databinding.FragmentMoviesBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MoviesFragment : Fragment(), RecyclerViewClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewModel: MoviesViewModel
    private lateinit var binding: FragmentMoviesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false)
        val view = binding.root

        val api = MoviesApi()
        val repository = MoviesRepository(api)
        val factory = MoviesViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MoviesViewModel::class.java)

        viewModel.getMovies()

        viewModel.movies.observe(viewLifecycleOwner, Observer { productList ->
            Log.d("products", "ProductList: ${productList}")

            binding.recylerViewMovies.also { recyclerView ->
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                recyclerView.setHasFixedSize(true)
                // Bu değişmeyen listeler için optimizasyon sağlar.
                // Kendi projende Paging yapacağın için yani eklemeler ve çıkarmalar yapacağın için,
                // Bunu kullanmamalısın.
                recyclerView.adapter = MoviesAdapter(productList, this)
            }

        })




        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MoviesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MoviesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onRecyclerViewItemClick(view: View, movie: Product) {
        when (view.id) {
            R.id.button_book -> {
                // todo some action
                Toast.makeText(requireContext(), "Book Button Clicked",Toast.LENGTH_SHORT).show()
            }

            R.id.layout_like -> {
                // todo some action
                Toast.makeText(requireContext(), "layout_like Clicked",Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onRecyclerViewItemLongClick(view: View, movie: Product) {
        when (view.id) {
            R.id.button_book -> {
                // todo some action
                Toast.makeText(requireContext(), "Book Button LONG Clicked",Toast.LENGTH_SHORT).show()
            }

            R.id.layout_like -> {
                // todo some action
                Toast.makeText(requireContext(), "layout_like LONG Clicked",Toast.LENGTH_SHORT).show()

            }
        }    }
}