package com.codeinglogs.moviedetails.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviedetails.databinding.MoviePagingItemBinding
import com.codeinglogs.presentation.model.movies.movieslist.Movies

class MoviesPagingAdapter():
    PagingDataAdapter<Movies, MoviesPagingAdapter.MoviesPagingViewHolder>(DriftUtils) {

    inner class MoviesPagingViewHolder(var binding : MoviePagingItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind() {
            val data = getItem(layoutPosition)
            binding.textViewUserName.text = data?.title
            data?.poster_path?.let {
                binding.imageView.load("https://image.tmdb.org/t/p/w500"+it,true)
            }
        }

    }

    companion object DriftUtils : DiffUtil.ItemCallback<Movies>(){
        override fun areItemsTheSame(
            oldItem: Movies,
            newItem: Movies
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Movies,
            newItem: Movies
        ) = oldItem == newItem
    }
    override fun onBindViewHolder(holder: MoviesPagingViewHolder, position: Int)  =holder.bind()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        MoviesPagingViewHolder(MoviePagingItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

}