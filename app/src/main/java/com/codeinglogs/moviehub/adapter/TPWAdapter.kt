package com.codeinglogs.moviehub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.databinding.TpwItemBinding
import com.codeinglogs.presentation.model.movies.movieslist.Movies

class TPWAdapter(): PagingDataAdapter<Movies, TPWAdapter.TPWViewHolder>(
    DriftUtils
) {

    inner class TPWViewHolder(var binding : TpwItemBinding): RecyclerView.ViewHolder(binding.root){

        init {

        }

        fun bind(){
            val data = getItem(layoutPosition)
            binding.textViewUserName.text = data?.title
            data?.poster_path?.let {
                binding.imageView.load("https://image.tmdb.org/t/p/w500"+it,true)
            }
        }
    }

    override fun onBindViewHolder(holder: TPWViewHolder, position: Int) =holder.bind()

    companion object DriftUtils : DiffUtil.ItemCallback<Movies>(){
        override fun areItemsTheSame(
            oldItem: Movies,
            newItem: Movies
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Movies,
            newItem: Movies
        ) = oldItem == newItem
    }

    interface OnItemClickListener {
        fun onItemClick(photo: Movies)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        TPWViewHolder(TpwItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

}