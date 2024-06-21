package com.example.recyclerviewmvvm.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("setImageWithGlide")
fun loadImage(view: ImageView, url:String?){
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(url)
            .into(view)
    }
    // we need a target for .into()
    // our target is an image view that we will give it as parameter
}


