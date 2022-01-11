package com.codeinglogs.moviedetails.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.moviedetails.databinding.ReviewItemBinding
import com.codeinglogs.presentation.model.movies.moviedetail.reviews.MovieReviews
import com.codeinglogs.presentation.model.movies.movieslist.Movies

class MovieReviewAdapter() : ListAdapter<MovieReviews, MovieReviewAdapter.MovieReviewViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<MovieReviews>(){
        override fun areItemsTheSame(
            oldItem: MovieReviews,
            newItem: MovieReviews
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: MovieReviews,
            newItem: MovieReviews
        ) = oldItem == newItem
    }


    inner class MovieReviewViewHolder(var binding : ReviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.tvAuthorReview.text=data.author
            Log.i("gkjnwk", "bind: ${data.author}")
            binding.tvContentReview.text=data.content
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = MovieReviewViewHolder(ReviewItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: MovieReviewViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTMovieClick(data : Movies)
        fun onUMovieClick()
    }

}