package com.codeinglogs.moviehub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviedetails.ui.activity.MovieDetailActivity
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.moviehub.databinding.MovieAndTvShowSecondaryItemBinding
import com.codeinglogs.presentation.model.movies.movieslist.Movies
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.ui.activity.TvShowDetailsActivity

class TvShowPagingAdapter(): PagingDataAdapter<TvShow, TvShowPagingAdapter.TvShowPagingViewHolder>(
    DriftUtils
) {

    inner class TvShowPagingViewHolder(var binding : MovieAndTvShowSecondaryItemBinding): RecyclerView.ViewHolder(binding.root){

        init {

        }

        fun bind(){
            val data = getItem(layoutPosition)
            val length=data?.first_air_date?.length?:0
            if(length>0)
                binding.tvYearMovieTvShowSecondaryYear.text=data?.first_air_date?.substring(0,4)
            else
                binding.tvYearMovieTvShowSecondaryYear.text=data?.first_air_date
            binding.tvTitleMovieTvShowSecondaryName.text = data?.name
            binding.tvRetingMovieTvShowSecondary.text = data?.vote_average.toString()
            binding.ivImageMovieTvShowSecondary.load(IMAGE_BASE_URL_500+data?.poster_path,true)

            binding.clMovieTvShowSecondary.setOnClickListener(){
                binding.root.context.startActivity(TvShowDetailsActivity.getInstance(binding.root.context,data?.id.toString()))
            }
        }
    }

    override fun onBindViewHolder(holder: TvShowPagingViewHolder, position: Int) =holder.bind()

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
        fun onItemClick(photo: TvShow)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        TvShowPagingViewHolder(MovieAndTvShowSecondaryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

}