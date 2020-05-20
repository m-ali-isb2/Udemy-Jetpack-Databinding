package com.muhammadali.udemy.jetpack.databinding.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * Created by Muhammad Ali on 19-May-20.
 * Email muhammad.ali9385@gmail.com
 */
abstract class BaseViewModel(application: Application) : AndroidViewModel(application),
    CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}