package com.codeinglogs.moviedetails.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.moviedetails.databinding.CrewItemBinding
import com.codeinglogs.presentation.model.movies.moviedetail.credits.MovieCrew
import com.codeinglogs.presentation.model.movies.movieslist.Movies

class CrewAdapter() : ListAdapter<MovieCrew, CrewAdapter.ViewHolder>(
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

    override fun getItemCount(): Int {
        if(super.getItemCount()<8)
            return super.getItemCount()
        else
            return 8
    }

    inner class ViewHolder(var binding : CrewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)
            Log.i("jkjkkj", "bind: ${data.name}")
            binding.tvCrewNameMovieInfo.text=data.name
            binding.tvCrewProfessionMovieInfo.text=data.known_for_department
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(CrewItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTMovieClick(data : Movies)
        fun onUMovieClick()
    }

}