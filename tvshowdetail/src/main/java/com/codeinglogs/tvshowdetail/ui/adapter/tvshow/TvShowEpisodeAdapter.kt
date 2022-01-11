package com.codeinglogs.tvshowdetail.ui.adapter.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.seasons.TvShowEpisode
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.databinding.TvShowSeasonEpisodeItemBinding

class TvShowEpisodeAdapter() : ListAdapter<TvShowEpisode, TvShowEpisodeAdapter.TvShowEpisodeViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<TvShowEpisode>(){
        override fun areItemsTheSame(
            oldItem: TvShowEpisode,
            newItem: TvShowEpisode
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: TvShowEpisode,
            newItem: TvShowEpisode
        ) = oldItem == newItem
    }


    inner class TvShowEpisodeViewHolder(var binding : TvShowSeasonEpisodeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.ivTvShowEpisode.load(IMAGE_BASE_URL_500 +data.still_path)
            binding.tvSeasonsNameTvShowEpisode.text=data.name
            binding.tvEpisodeCountTvShoeEpisode.text="Episode "+data.episode_number
            binding.tvSeasonsDateTvShowEpisode.text=data.air_date
            binding.tvDescriptionTvShowEpisodeEpisode.text=data.overview
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = TvShowEpisodeViewHolder(TvShowSeasonEpisodeItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: TvShowEpisodeViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTTvShowClick(data : TvShow)
        fun onUTvShowClick()
    }

}