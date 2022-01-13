package com.codeinglogs.moviedetails.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviedetails.databinding.PersonItemBinding
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.movies.moviedetail.credits.MovieCrew
import com.codeinglogs.presentation.model.movies.movieslist.Movies

class MovieAllCrewAdapter: ListAdapter<MovieCrew, MovieAllCrewAdapter.MovieAllCrewViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<MovieCrew>(){
        override fun areItemsTheSame(
            oldItem: MovieCrew,
            newItem: MovieCrew
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: MovieCrew,
            newItem: MovieCrew
        ) = oldItem == newItem
    }

    inner class MovieAllCrewViewHolder(var binding : PersonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)
            binding.ivPersonImage.load(IMAGE_BASE_URL_500 +data.profile_path)
            binding.tvName.text=data.name
            binding.tvProfession.text=data.known_for_department
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = MovieAllCrewViewHolder(
        PersonItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: MovieAllCrewViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTMovieClick(data : Movies)
        fun onUMovieClick()
    }

}