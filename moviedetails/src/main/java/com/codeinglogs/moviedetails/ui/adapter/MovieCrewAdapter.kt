package com.codeinglogs.moviedetails.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.moviedetails.databinding.CrewItemBinding
import com.codeinglogs.presentation.model.movies.movieslist.Movies
import com.codeinglogs.presentation.model.person.personlist.Person

class MovieCrewAdapter() : ListAdapter<Person, MovieCrewAdapter.MovieCrewViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<Person>(){
        override fun areItemsTheSame(
            oldItem: Person,
            newItem: Person
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Person,
            newItem: Person
        ) = oldItem == newItem
    }

    override fun getItemCount(): Int {
        if(super.getItemCount()<8)
            return super.getItemCount()
        else
            return 8
    }

    inner class MovieCrewViewHolder(var binding : CrewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)
            Log.i("jkjkkj", "bind: ${data.name}")
            binding.tvCrewNameMovieInfo.text=data.name
            binding.tvCrewProfessionMovieInfo.text=data.known_for_department
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = MovieCrewViewHolder(CrewItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: MovieCrewViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTMovieClick(data : Movies)
        fun onUMovieClick()
    }

}