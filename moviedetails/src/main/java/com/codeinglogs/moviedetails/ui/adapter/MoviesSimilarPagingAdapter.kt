package com.codeinglogs.moviedetails.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviedetails.databinding.MovieItemBinding
import com.codeinglogs.moviedetails.databinding.MoviePagingItemBinding
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.movies.movieslist.Movies

class MoviesSimilarPagingAdapter():
    PagingDataAdapter<Movies, MoviesSimilarPagingAdapter.MoviesPagingViewHolder>(DriftUtils) {

    inner class MoviesPagingViewHolder(var binding : MovieItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind() {
            val data = getItem(layoutPosition)
            binding.ivMovie.load(IMAGE_BASE_URL_500 +data?.poster_path)
            binding.tvMovieName.text=data?.title
            binding.tvReting.text=data?.vote_average.toString()
            if(data?.release_date?.length?:0>0)
                binding.tvYear.text=data?.release_date?.substring(0,4)
            else
                binding.tvYear.text=data?.release_date
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
        MoviesPagingViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

}