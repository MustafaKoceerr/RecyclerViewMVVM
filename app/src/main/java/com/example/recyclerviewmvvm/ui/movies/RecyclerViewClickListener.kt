package com.example.recyclerviewmvvm.ui.movies

import android.view.View
import com.example.recyclerviewmvvm.data.model.Product

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, movie:Product)
    // if you dont pass a view you cannot dettect that which view was clicked
    // because all the cases, this function will be called
    // and I wanna pass movie because I want to send the selected product
    fun onRecyclerViewItemLongClick(view: View, movie:Product)
}