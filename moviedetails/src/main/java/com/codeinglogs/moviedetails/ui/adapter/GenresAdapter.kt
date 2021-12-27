package com.codeinglogs.moviedetails.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.moviedetails.databinding.GenresItemBinding
import com.codeinglogs.presentation.model.moviedetail.info.Gener
import com.codeinglogs.presentation.model.movies.movieslist.Movies

class GenresAdapter() : ListAdapter<Gener, GenresAdapter.ViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<Gener>(){
        override fun areItemsTheSame(
            oldItem: Gener,
            newItem: Gener
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Gener,
            newItem: Gener
        ) = oldItem == newItem
    }


    inner class ViewHolder(var binding : GenresItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.tvGenres.text=data.name
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(GenresItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTMovieClick(data : Movies)
        fun onUMovieClick()
    }

}