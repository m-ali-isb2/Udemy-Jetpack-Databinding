package com.muhammadali.udemy.jetpack.databinding.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Muhammad Ali on 05-May-20.
 * Email muhammad.ali9385@gmail.com
 */
class DogsService {


    private val BASE_URL = "https://raw.githubusercontent.com/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(DogsAPI::class.java)

    fun getDogs(): Single<List<DogBreed>> {
        return api.getDogs()
    }
}