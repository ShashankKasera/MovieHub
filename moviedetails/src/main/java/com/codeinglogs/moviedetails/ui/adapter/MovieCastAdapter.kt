package com.codeinglogs.moviedetails.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviedetails.databinding.PersonItemBinding
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.movies.movieslist.Movies
import com.codeinglogs.presentation.model.person.personlist.Person

class MovieCastAdapter() : ListAdapter<Person, MovieCastAdapter.MovieCastViewHolder>(
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


    inner class MovieCastViewHolder(var binding : PersonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
//            binding.root.setOnClickListener {
//                binding.root.context.startActivity(context,getItem(layoutPosition).id.toString()))
//            }
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.ivPersonImage.load(IMAGE_BASE_URL_500+data.profile_path)
            binding.tvName.text=data.name
            binding.tvProfession.text=data.character
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = MovieCastViewHolder(PersonItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: MovieCastViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTMovieClick(data : Movies)
        fun onUMovieClick()
    }

}