package com.codeinglogs.persondetails.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.persondetails.databinding.PersonCreditsItemBinding
import com.codeinglogs.presentation.model.movies.movieslist.Movies
import com.codeinglogs.presentation.model.person.persondetails.moviecredits.PersonMovieCastAndCrew
import com.codeinglogs.presentation.model.person.persondetails.tvcredits.PersonTvCastAndCrew

class PersonTvCreditsAdapter() : ListAdapter<PersonTvCastAndCrew, PersonTvCreditsAdapter.PersonTvCreditsViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<PersonTvCastAndCrew>(){
        override fun areItemsTheSame(
            oldItem: PersonTvCastAndCrew,
            newItem: PersonTvCastAndCrew
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: PersonTvCastAndCrew,
            newItem: PersonTvCastAndCrew
        ) = oldItem == newItem
    }


    inner class PersonTvCreditsViewHolder(var binding : PersonCreditsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.ivPosterPersonCredits.load(IMAGE_BASE_URL_500 +data.backdrop_path)
            binding.tvRetingPersonCredits.text=data.vote_average.toString()
            binding.tvNamePersonCredits.text=data.name

            if(data.first_air_date.length>0)
                binding.tvYear.text=data.first_air_date.substring(0,4)
            else
                binding.tvYear.text=data.first_air_date
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = PersonTvCreditsViewHolder(PersonCreditsItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: PersonTvCreditsViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTMovieClick(data : Movies)
        fun onUMovieClick()
    }

}
