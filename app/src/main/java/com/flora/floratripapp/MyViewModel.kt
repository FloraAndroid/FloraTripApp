package com.flora.floratripapp

import android.icu.util.TimeUnit.values
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flora.floratripapp.network.ApiInterface
import com.flora.floratripapp.network.ServiceBuilder
import com.flora.floratripapp.view.model.Result
import com.flora.floratripapp.view.model.ViewData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.time.chrono.JapaneseEra.values

class MyViewModel(serviceBuilder: ServiceBuilder) : ViewModel() {

    val loading = MutableLiveData<Result>()

    private val apiInterface: ApiInterface = serviceBuilder.buildService(ApiInterface::class.java)

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                loading.postValue(Result.Loading(true))
                val response = apiInterface.getArticle()
                var list = response?.data?.map {
                    var isSaved = if (it.isSaved) R.drawable.ic_saved else R.drawable.ic_save
                    var isLiked = if (it.isLiked) R.drawable.ic_liked else R.drawable.ic_like
                    var count = if (it.isLiked) it.likesCount.toString() else ""


                    ViewData(
                        it.title, it.imageUrl, it.author.authorAvatar.imageUrl,
                        it.author.authorName, it.metaData.creationTime,
                        isSaved, isLiked, count,
                        it.category, it.id
                    )
                }
                if (!list.isNullOrEmpty()) {
                    loading.postValue(Result.Success(list))
                } else {
                    loading.postValue(Result.Failure("No Articles Founded"))
                }
            } catch (e: Exception) {
                loading.postValue(Result.Failure(e.message))
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
    
}