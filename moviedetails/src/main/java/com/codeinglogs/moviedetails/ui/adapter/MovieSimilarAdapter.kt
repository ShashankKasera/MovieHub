package com.codeinglogs.moviedetails.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviedetails.databinding.MovieItemBinding
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.movies.moviedetail.similar.MovieSimilar
import com.codeinglogs.presentation.model.movies.movieslist.Movies

class MovieSimilarAdapter() : ListAdapter<MovieSimilar, MovieSimilarAdapter.ViewHolder>(DriftUtils){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<MovieSimilar>(){
        override fun areItemsTheSame(
            oldItem: MovieSimilar,
            newItem: MovieSimilar
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: MovieSimilar,
            newItem: MovieSimilar
        ) = oldItem == newItem
    }



    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(MovieItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind(position)

    inner class ViewHolder(val binding : MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.ivMovie.load(IMAGE_BASE_URL_500 +data.poster_path)
            binding.tvReting.text=data.vote_average.toString()
            if(data.release_date.length>0)
                binding.tvYear.text=data.release_date.substring(0,4)
            else
                binding.tvYear.text=data.release_date
        }
    }

    interface Actions {
        fun onTMovieClick(data : Movies)
        fun onUMovieClick()
    }

}
