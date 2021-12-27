package com.codeinglogs.moviedetails.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviedetails.databinding.PersonItemBinding
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.moviedetail.credits.Cast
import com.codeinglogs.presentation.model.movies.movieslist.Movies

class CastAdapter() : ListAdapter<Cast, CastAdapter.ViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<Cast>(){
        override fun areItemsTheSame(
            oldItem: Cast,
            newItem: Cast
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Cast,
            newItem: Cast
        ) = oldItem == newItem
    }


    inner class ViewHolder(var binding : PersonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.tvProfileImage.load(IMAGE_BASE_URL_500+data.profile_path)
            binding.tvName.text=data.name
            binding.tvProfession.text=data.character
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(PersonItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTMovieClick(data : Movies)
        fun onUMovieClick()
    }

}