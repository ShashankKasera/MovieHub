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
//import com.codeinglogs.tvshowdetail.ui.activity.TvShowDetailsActivity

class PersonMovieCreditsAdapter() : ListAdapter<PersonMovieCastAndCrew, PersonMovieCreditsAdapter.PersonMovieCreditsViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<PersonMovieCastAndCrew>(){
        override fun areItemsTheSame(
            oldItem: PersonMovieCastAndCrew,
            newItem: PersonMovieCastAndCrew
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: PersonMovieCastAndCrew,
            newItem: PersonMovieCastAndCrew
        ) = oldItem == newItem
    }


    inner class PersonMovieCreditsViewHolder(var binding : PersonCreditsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.clMovieTvShow.setOnClickListener {
                //binding.root.context.startActivity(MovieDetailActivity.getInstance(binding.root.context,getItem(layoutPosition).id.toString()))
            }
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.ivPosterPersonCredits.load(IMAGE_BASE_URL_500 +data.backdrop_path)
            binding.tvRetingPersonCredits.text=data.vote_average.toString()
            binding.tvNamePersonCredits.text=data.title
            if(data.release_date.length>0)
                binding.tvYear.text=data.release_date.substring(0,4)
            else
                binding.tvYear.text=data.release_date
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = PersonMovieCreditsViewHolder(PersonCreditsItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: PersonMovieCreditsViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTMovieClick(data : Movies)
        fun onUMovieClick()
    }

}
