package com.muhammadali.udemy.jetpack.room.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muhammadali.udemy.jetpack.room.model.DogBreed
import com.muhammadali.udemy.jetpack.room.model.DogDatabase
import kotlinx.coroutines.launch

/**
 * Created by Muhammad Ali on 05-May-20.
 * Email muhammad.ali9385@gmail.com
 */
class DetailViewModel(application: Application) : BaseViewModel(application) {


    val dogObj = MutableLiveData<DogBreed>()
    private var uuid: Long? = null

    fun setDetails(uuid: Long) {
        this.uuid = uuid
        fetchFromDatabase()
    }

    fun setDogDetails(dogBreed: DogBreed) {
        dogObj.value = dogBreed
    }

    private fun fetchFromDatabase() {
        launch {
            val dao = DogDatabase(getApplication()).dogDao()
            setDogDetails(dao.getDog(uuid!!.toInt()))
        }
    }
}