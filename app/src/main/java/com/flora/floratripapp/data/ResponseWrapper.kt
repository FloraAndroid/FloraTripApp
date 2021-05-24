package com.flora.floratripapp.data

import com.flora.floratripapp.view.model.ViewData


data class ResponseData(val data: ArrayList<ArticleItem>)
data class ArticleItem(
    val author: Author,
    val category: String,
    val id: String,
    val imageUrl: String,
    val isLiked: Boolean,
    val isSaved: Boolean,
    val likesCount: Int,
    val metaData: MetaData,
    val title: String
) {
    data class Author(
        val authorAvatar: AuthorAvatar,
        val authorName: String,
        val id: String
    ) {
        data class AuthorAvatar(
            val imageUrl: String
        )
    }
    data class MetaData(
        val creationTime: String,
        val updateTime: String
    )

    sealed class Result<out T : Any> {
        data class Success<out T : Any>(val data: T) : Result<T>()
        data class Error(val exception: Exception) : Result<Nothing>()
    }
}