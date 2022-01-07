package com.codeinglogs.tvshowdetail.ui.adapter.tvshowseason

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.info.TvShowSeason
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.databinding.TvShowSeasonsBinding

class TvShowSeasonsAdapter() : ListAdapter<TvShowSeason, TvShowSeasonsAdapter.ViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<TvShowSeason>(){
        override fun areItemsTheSame(
            oldItem: TvShowSeason,
            newItem: TvShowSeason
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: TvShowSeason,
            newItem: TvShowSeason
        ) = oldItem == newItem
    }


    inner class ViewHolder(var binding : TvShowSeasonsBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.ivSeasonsTvShow.load(IMAGE_BASE_URL_500 +data.poster_path)

            binding.tvSeasonsNumTvShow.text=data.name
            binding.tvEpisodeCountTvShow.text="Episode "+data.episode_count.toString()
            binding.tvSeasonsDateTvShow.text=data.air_date
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(TvShowSeasonsBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTTvShowClick(data : TvShow)
        fun onUTvShowClick()
    }

}