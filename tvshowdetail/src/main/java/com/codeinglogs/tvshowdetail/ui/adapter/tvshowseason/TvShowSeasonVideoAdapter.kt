package com.codeinglogs.tvshowdetail.ui.adapter.tvshowseason

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_YOUTUBE
import com.codeinglogs.moviehub.constant.IMAGE_back_YOUTUBE
import com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.seasonvideo.TvShowsSeasonVideos
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.databinding.TvShowVideoBinding

class TvShowSeasonVideoAdapter() : ListAdapter<TvShowsSeasonVideos, TvShowSeasonVideoAdapter.TvShowSeasonVideoViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<TvShowsSeasonVideos>(){
        override fun areItemsTheSame(
            oldItem: TvShowsSeasonVideos,
            newItem: TvShowsSeasonVideos
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: TvShowsSeasonVideos,
            newItem: TvShowsSeasonVideos
        ) = oldItem == newItem
    }


    inner class TvShowSeasonVideoViewHolder(var binding : TvShowVideoBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.ivVideo.load(IMAGE_BASE_URL_YOUTUBE +data.key+IMAGE_back_YOUTUBE)

            Log.i("ihik", "bind: ${IMAGE_BASE_URL_YOUTUBE +data.key+IMAGE_back_YOUTUBE}")
            binding.tvVideoTitle.text=data.name
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = TvShowSeasonVideoViewHolder(TvShowVideoBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: TvShowSeasonVideoViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTTvShowClick(data : TvShow)
        fun onUTvShowClick()
    }

}