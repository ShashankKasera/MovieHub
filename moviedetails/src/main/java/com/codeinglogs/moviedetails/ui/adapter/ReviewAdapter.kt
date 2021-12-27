package com.codeinglogs.moviedetails.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviedetails.databinding.PersonItemBinding
import com.codeinglogs.moviedetails.databinding.ReviewItemBinding
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.moviedetail.credits.Cast
import com.codeinglogs.presentation.model.moviedetail.reviews.MovieReviews
import com.codeinglogs.presentation.model.movies.movieslist.Movies

class ReviewAdapter() : ListAdapter<MovieReviews, ReviewAdapter.ViewHolder>(
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


    inner class ViewHolder(var binding : ReviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.tvAuthorReview.text=data.author
            Log.i("gkjnwk", "bind: ${data.author}")
            binding.tvContentReview.text=data.content
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(ReviewItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTMovieClick(data : Movies)
        fun onUMovieClick()
    }

}