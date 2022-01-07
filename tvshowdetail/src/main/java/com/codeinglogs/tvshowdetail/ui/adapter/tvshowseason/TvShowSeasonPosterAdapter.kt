package com.codeinglogs.tvshowdetail.ui.adapter.tvshowseason

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.seasonimage.TvShowSeasonPoster
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.databinding.PosterItemBinding

class TvShowSeasonPosterAdapter() : ListAdapter<TvShowSeasonPoster, TvShowSeasonPosterAdapter.ViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<TvShowSeasonPoster>(){
        override fun areItemsTheSame(
            oldItem: TvShowSeasonPoster,
            newItem: TvShowSeasonPoster
        ) = oldItem.file_path == newItem.file_path

        override fun areContentsTheSame(
            oldItem: TvShowSeasonPoster,
            newItem: TvShowSeasonPoster
        ) = oldItem == newItem
    }


    inner class ViewHolder(var binding : PosterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.ivPoster.load(IMAGE_BASE_URL_500+data.file_path)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(PosterItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTTvShowClick(data : TvShow)
        fun onUTvShowClick()
    }

}