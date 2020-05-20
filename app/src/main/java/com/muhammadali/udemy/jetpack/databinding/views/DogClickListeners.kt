package com.muhammadali.udemy.jetpack.databinding.views

import android.view.View
import android.widget.ImageView
import com.muhammadali.udemy.jetpack.databinding.model.DogBreed

/**
 * Created by Muhammad Ali on 20-May-20.
 * Email muhammad.ali9385@gmail.com
 */
interface DogClickListeners {
    fun onClick(view :View,dogBreed: DogBreed)
}