package com.codeinglogs.moviehub

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.databinding.MovieItemBinding
import com.codeinglogs.presentation.model.trendingmovies.Result

class TrendingMoviesAdapter():
    PagingDataAdapter<Result, TrendingMoviesAdapter.TrandingMoviesViewHolder>(DriftUtils) {

    inner class TrandingMoviesViewHolder(var binding : MovieItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind() {
            val data = getItem(layoutPosition)
            binding.textViewUserName.text = data?.original_title
            data?.poster_path?.let {
                binding.imageView.load("https://image.tmdb.org/t/p/w500"+it,true)
            }
        }

    }

    companion object DriftUtils : DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(
            oldItem: Result,
            newItem: Result
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Result,
            newItem: Result
        ) = oldItem == newItem
    }
    override fun onBindViewHolder(holder: TrandingMoviesViewHolder, position: Int)  =holder.bind()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        TrandingMoviesViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

}