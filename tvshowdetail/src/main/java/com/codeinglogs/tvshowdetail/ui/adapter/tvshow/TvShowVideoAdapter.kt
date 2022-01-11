package com.codeinglogs.tvshowdetail.ui.adapter.tvshow

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_YOUTUBE
import com.codeinglogs.moviehub.constant.IMAGE_back_YOUTUBE
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.video.TvShowsVideos
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.databinding.TvShowVideoBinding

class TvShowVideoAdapter() : ListAdapter<TvShowsVideos, TvShowVideoAdapter.TvShowVideoViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<TvShowsVideos>(){
        override fun areItemsTheSame(
            oldItem: TvShowsVideos,
            newItem: TvShowsVideos
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: TvShowsVideos,
            newItem: TvShowsVideos
        ) = oldItem == newItem
    }


    inner class TvShowVideoViewHolder(var binding : TvShowVideoBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.ivVideo.load(IMAGE_BASE_URL_YOUTUBE +data.key+IMAGE_back_YOUTUBE)

            Log.i("ihik", "bind: ${IMAGE_BASE_URL_YOUTUBE +data.key+IMAGE_back_YOUTUBE}")
            binding.tvVideoTitle.text=data.name
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = TvShowVideoViewHolder(TvShowVideoBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: TvShowVideoViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTTvShowClick(data : TvShow)
        fun onUTvShowClick()
    }

}