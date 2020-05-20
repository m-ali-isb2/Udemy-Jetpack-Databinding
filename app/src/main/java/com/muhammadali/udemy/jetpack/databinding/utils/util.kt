package com.muhammadali.udemy.jetpack.databinding.utils

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.muhammadali.udemy.jetpack.databinding.R

/**
 * Created by Muhammad Ali on 05-May-20.
 * Email muhammad.ali9385@gmail.com
 */

fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

fun ImageView.loadImage(url: String?, progressDrawable: CircularProgressDrawable) {
    val options: RequestOptions = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_dog)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}