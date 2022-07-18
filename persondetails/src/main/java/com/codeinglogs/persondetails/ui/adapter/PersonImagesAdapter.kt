package com.codeinglogs.persondetails.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.persondetails.databinding.PersonImagesBinding
import com.codeinglogs.presentation.model.movies.movieslist.Movies
import com.codeinglogs.presentation.model.person.persondetails.images.PersonImages

class PersonImagesAdapter() : ListAdapter<PersonImages, PersonImagesAdapter.PersonImagesViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<PersonImages>(){
        override fun areItemsTheSame(
            oldItem: PersonImages,
            newItem: PersonImages
        ) = oldItem.file_path == newItem.file_path

        override fun areContentsTheSame(
            oldItem: PersonImages,
            newItem: PersonImages
        ) = oldItem == newItem
    }


    inner class PersonImagesViewHolder(var binding : PersonImagesBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)
            Log.i("mhmklkmf", "bind: ${IMAGE_BASE_URL_500+data.file_path} ")
            binding.ivPersonImages.load(IMAGE_BASE_URL_500+data.file_path)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = PersonImagesViewHolder(PersonImagesBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: PersonImagesViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTMovieClick(data : Movies)
        fun onUMovieClick()
    }

}