package com.codeinglogs.tvshowdetail.ui.adapter.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.presentation.model.movies.movieslist.Movies
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.credits.TvShowCast
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.databinding.TvShowPagingItemBinding

class TvShowPagingAdatper: PagingDataAdapter<TvShow, TvShowPagingAdatper.TvShowPagingViewHolder>(
    DriftUtils
) {

    inner class TvShowPagingViewHolder(var binding : TvShowPagingItemBinding): RecyclerView.ViewHolder(binding.root){

        init {

        }

        fun bind(){
            val data = getItem(layoutPosition)
            binding.textViewUserName.text = data?.name
            data?.poster_path.let {
                binding.imageView.load("https://image.tmdb.org/t/p/w500"+it,true)
            }
        }
    }

    override fun onBindViewHolder(holder: TvShowPagingViewHolder, position: Int)=holder.bind()

    companion object DriftUtils : DiffUtil.ItemCallback<TvShow>(){
        override fun areItemsTheSame(
            oldItem: TvShow,
            newItem: TvShow
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: TvShow,
            newItem: TvShow
        ) = oldItem == newItem
    }

    interface OnItemClickListener {
        fun onItemClick(photo: Movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        TvShowPagingViewHolder(TvShowPagingItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

}