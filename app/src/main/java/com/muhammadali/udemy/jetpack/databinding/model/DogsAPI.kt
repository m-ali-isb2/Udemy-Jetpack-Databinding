package com.muhammadali.udemy.jetpack.databinding.model

import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Muhammad Ali on 05-May-20.
 * Email muhammad.ali9385@gmail.com
 */
interface DogsAPI {
    @GET("DevTides/DogsApi/master/dogs.json")
    fun getDogs(): Single<List<DogBreed>>
//
//    @GET
//    fun getDogs(@Url url: String): Single<>
}