package com.flora.floratripapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.flora.floratripapp.network.ServiceBuilder

class MyViewModelFactory(private val service: ServiceBuilder): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MyViewModel::class.java)){
            return MyViewModel(service ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")

    }
}