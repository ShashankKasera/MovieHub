package com.codeinglogs.moviehub.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.moviehub.databinding.MoviesAndTvShowPrimaryItemBinding
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.squareup.picasso.Picasso

class TvShowsPrimaryAdapter : ListAdapter<TvShow, TvShowsPrimaryAdapter.TvShowsPrimaryViewHolder>(DriftUtils) {

    companion object DriftUtils : DiffUtil.ItemCallback<TvShow>(){
        override fun areItemsTheSame(
            oldItem: TvShow,
            newItem: TvShow
        
        )= oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: TvShow,
            newItem: TvShow
        )= oldItem == newItem

    }

    inner class TvShowsPrimaryViewHolder(var binding : MoviesAndTvShowPrimaryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
//            binding.textView.setOnClickListener {
//                action.onTMovieClick(getItem(layoutPosition))
//            }
//            binding.textView2.setOnClickListener {
//                action.onUMovieClick()
//            }
//            binding.textView3.setOnClickListener {
//                var x = callback(10)
//            }
        }
        fun bind(){
            val data = getItem(layoutPosition)

            binding.tvTitel.text = data.original_name
            binding.tvRetingMovies.text = data.vote_average.toString()
            Log.i("kgnjkwkn", "bind:     https://image.tmdb.org/t/p/w500${data.poster_path}")
            binding.ivMovieImage.load(IMAGE_BASE_URL_500+data.poster_path,true)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = TvShowsPrimaryViewHolder(MoviesAndTvShowPrimaryItemBinding.inflate(
        LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: TvShowsPrimaryAdapter.TvShowsPrimaryViewHolder, position: Int) = viewHolder.bind()



}