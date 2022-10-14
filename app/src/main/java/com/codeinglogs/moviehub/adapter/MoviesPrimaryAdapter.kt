package com.codeinglogs.moviehub.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.codeinglogs.core.extension.load
import com.codeinglogs.moviedetails.ui.activity.MovieDetailActivity
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.moviehub.databinding.MoviesAndTvShowPrimaryItemBinding
import com.codeinglogs.persondetails.ui.activity.PersonDetailsActivity
import com.codeinglogs.presentation.model.movies.movieslist.Movies

class MoviesPrimaryAdapter : ListAdapter<Movies, MoviesPrimaryAdapter.MoviesPrimaryViewHolder>(DriftUtils) {

    companion object DriftUtils : DiffUtil.ItemCallback<Movies>(){
        override fun areItemsTheSame(
            oldItem: Movies,
            newItem: Movies
        
        )= oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Movies,
            newItem: Movies
        )= oldItem == newItem

    }

    inner class MoviesPrimaryViewHolder(var binding : MoviesAndTvShowPrimaryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.ivMovieImage.setOnClickListener {
                Log.i("njknjk", ": ${getItem(layoutPosition).id} ")
                binding.root.context.startActivity(MovieDetailActivity.getInstance(binding.root.context,getItem(layoutPosition).id.toString()))
            }
        }
        fun bind(){
            val data = getItem(layoutPosition)

            binding.tvTitel.text=data.title
            binding.tvRetingMovies.text=data.vote_average.toString()
            Log.i("uihiwg", "bind: ${data.poster_path}")
            binding.ivMovieImage.load(IMAGE_BASE_URL_500 +data.poster_path,true)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = MoviesPrimaryViewHolder(MoviesAndTvShowPrimaryItemBinding.inflate(
        LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: MoviesPrimaryAdapter.MoviesPrimaryViewHolder, position: Int) = viewHolder.bind()


}