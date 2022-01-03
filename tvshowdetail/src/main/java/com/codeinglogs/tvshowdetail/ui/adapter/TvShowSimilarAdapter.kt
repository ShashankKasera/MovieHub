package com.codeinglogs.tvshowdetail.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.similar.TvShowSimilar
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.databinding.TvShowItemBinding

class TvShowSimilarAdapter() : ListAdapter<TvShowSimilar, TvShowSimilarAdapter.ViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<TvShowSimilar>(){
        override fun areItemsTheSame(
            oldItem: TvShowSimilar,
            newItem: TvShowSimilar
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: TvShowSimilar,
            newItem: TvShowSimilar
        ) = oldItem == newItem
    }


    inner class ViewHolder(var binding : TvShowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.ivTvShow.load(IMAGE_BASE_URL_500 +data.backdrop_path)
            binding.tvTvShowName.text=data.name
            binding.tvReting.text=data.vote_average.toString()
            if(data.first_air_date.length>0)
                binding.tvYear.text=data.first_air_date.substring(0,4)
            else
                binding.tvYear.text=data.first_air_date
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(TvShowItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTTvShowClick(data : TvShow)
        fun onUMovieClick()
    }

}
