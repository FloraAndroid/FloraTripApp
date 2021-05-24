package com.flora.floratripapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.flora.floratripapp.databinding.ItemLayoutBinding
import com.flora.floratripapp.view.model.ViewData

class ArticleListAdapter() : ListAdapter<ViewData, ArticleListAdapter.MyViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<ViewData>() {
        override fun areItemsTheSame(oldItem: ViewData, newItem: ViewData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ViewData, newItem: ViewData): Boolean {
            return oldItem.id == newItem.id
        }

    }

    inner class MyViewHolder(val biding: ItemLayoutBinding) : RecyclerView.ViewHolder(biding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(layoutInflater)
        return MyViewHolder((binding))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.biding.item = getItem(position)
        holder.biding.executePendingBindings()
    }

}