package com.codeinglogs.moviedetails.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviedetails.databinding.MovieAndTvShowVideoBinding
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_YOUTUBE
import com.codeinglogs.moviehub.constant.IMAGE_back_YOUTUBE
import com.codeinglogs.presentation.model.moviedetail.videos.MovieVideo
import com.codeinglogs.presentation.model.movies.movieslist.Movies

class VideoAdapter() : ListAdapter<MovieVideo, VideoAdapter.ViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<MovieVideo>(){
        override fun areItemsTheSame(
            oldItem: MovieVideo,
            newItem: MovieVideo
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: MovieVideo,
            newItem: MovieVideo
        ) = oldItem == newItem
    }


    inner class ViewHolder(var binding : MovieAndTvShowVideoBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.ivVideo.load(IMAGE_BASE_URL_YOUTUBE +data.key+IMAGE_back_YOUTUBE)

            Log.i("ihik", "bind: ${IMAGE_BASE_URL_YOUTUBE +data.key+IMAGE_back_YOUTUBE}")
            binding.tvVideoTitle.text=data.name
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(MovieAndTvShowVideoBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTMovieClick(data : Movies)
        fun onUMovieClick()
    }

}
//"https://img.youtube.com/vi/w500IQqqAWMIIAQ/sddefault.jpg"
//"https://image.tmdb.org/t/p/w500IQqqAWMIIAQ/sddefault.jpg"