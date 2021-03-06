package com.codeinglogs.moviedetails.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.moviedetails.databinding.GenresItemBinding
import com.codeinglogs.presentation.model.movies.moviedetail.info.MovieGener
import com.codeinglogs.presentation.model.movies.movieslist.Movies

class MovieGenresAdapter() : ListAdapter<MovieGener, MovieGenresAdapter.MovieGenresViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<MovieGener>(){
        override fun areItemsTheSame(
            oldItem: MovieGener,
            newItem: MovieGener
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: MovieGener,
            newItem: MovieGener
        ) = oldItem == newItem
    }


    inner class MovieGenresViewHolder(var binding : GenresItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.tvGenres.text=data.name
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = MovieGenresViewHolder(GenresItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: MovieGenresViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTMovieClick(data : Movies)
        fun onUMovieClick()
    }

}