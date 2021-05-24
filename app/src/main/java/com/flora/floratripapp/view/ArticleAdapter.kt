package com.flora.floratripapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.flora.floratripapp.databinding.ItemLayoutBinding
import com.flora.floratripapp.view.model.ViewData

class ArticleAdapter(val list: List<ViewData>) :
    RecyclerView.Adapter<ArticleAdapter.MViewHolder>() {

    //    companion object {
//        private val Movie_COMPARATOR = object : DiffUtil.ItemCallback<MovieItem>() {
//            override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean =
//                oldItem.title == newItem.title
//
//            override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean =
//                oldItem == newItem
//        }
//    }
    companion object {
        private val COMPARATOR = object :
            DiffUtil.ItemCallback<ViewData>() {

            override fun areItemsTheSame(oldItem: ViewData, newItem: ViewData): Boolean =
                oldItem === newItem

            override fun areContentsTheSame(oldItem: ViewData, newItem: ViewData): Boolean =
                oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleAdapter.MViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(layoutInflater)
        return MViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        val currentUser = list.get(position)
        holder.binding.item = currentUser
        holder.binding.executePendingBindings()
    }
}
