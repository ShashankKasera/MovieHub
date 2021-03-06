package com.codeinglogs.tvshowdetail.ui.adapter.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.info.TvShowGenre
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.databinding.TvShowGenresItemBinding

class TvShowGenresAdapter() : ListAdapter<TvShowGenre, TvShowGenresAdapter.TvShowGenresViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<TvShowGenre>(){
        override fun areItemsTheSame(
            oldItem: TvShowGenre,
            newItem: TvShowGenre
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: TvShowGenre,
            newItem: TvShowGenre
        ) = oldItem == newItem
    }


    inner class TvShowGenresViewHolder(var binding : TvShowGenresItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)
            binding.tvGenres.text=data.name
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = TvShowGenresViewHolder(TvShowGenresItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: TvShowGenresViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTTvShowClick(data : TvShow)
        fun onUTvShowClick()
    }

}