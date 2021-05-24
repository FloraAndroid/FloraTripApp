package com.flora.floratripapp.view.model

import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.flora.floratripapp.R




data class ViewData(
    var title: String, var photo: String,
    var avatarPhoto: String, var avatarName: String,
    var date: String, var isSaved: Int,
    var isLiked: Int, var countLike: String,
    var category: String, var id: String
)

sealed class Result {
    data class Success(val data : List<ViewData>) : Result()
    data class Failure(val exception : String?) : Result()
    data class Loading(val loading:Boolean):Result()
}


object Companion {

    @JvmStatic
    @BindingAdapter("binding:icon")
    fun setImageResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }

    @JvmStatic
    @BindingAdapter(value = ["setImageUrl"])
    fun ImageView.bindImageUrl(url: String?) {
        if (!url.isNullOrBlank()) {
            Glide.with(this).load(url).centerCrop()
                .error(R.drawable.ic_close_24)
                .into(this)
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["setupVisibility"])
    fun ProgressBar.progressVisibility(loadingState: Result?) {
        loadingState?.let {
            isVisible = when (it) {
                is Result.Loading -> it.loading
                is Result.Failure -> false
                is Result.Success -> false
            }

        }
        if(loadingState==null){
            isVisible=true
        }
    }
}