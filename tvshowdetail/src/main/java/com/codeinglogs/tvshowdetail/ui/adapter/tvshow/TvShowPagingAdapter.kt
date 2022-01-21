package com.codeinglogs.tvshowdetail.ui.adapter.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.movies.movieslist.Movies
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.databinding.TvShowItemBinding
import com.codeinglogs.tvshowdetail.databinding.TvShowPagingItemBinding

class TvShowPagingAdapter: PagingDataAdapter<TvShow, TvShowPagingAdapter.TvShowPagingViewHolder>(
    DriftUtils
) {

    inner class TvShowPagingViewHolder(var binding : TvShowItemBinding): RecyclerView.ViewHolder(binding.root){

        init {

        }

        fun bind(){
            val data = getItem(layoutPosition)
            binding.tvTvShowName.text = data?.name
            binding.tvReting.text = data?.vote_average.toString()
            data?.poster_path.let {
                binding.ivTvShow.load(IMAGE_BASE_URL_500+it,true)
            }

            if(data?.first_air_date?.length?:0>0)
                binding.tvTvShowYear.text=data?.first_air_date?.substring(0,4)
            else
                binding.tvTvShowYear.text=data?.first_air_date
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
        TvShowPagingViewHolder(TvShowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

}