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
import com.codeinglogs.tvshowdetail.ui.activity.TvShowAllCrewActivity
import com.codeinglogs.tvshowdetail.ui.activity.TvShowSeasonDetailsActivity

class MoviePagingAdapter(): PagingDataAdapter<Movies, MoviePagingAdapter.MoviePagingViewHolder>(
    DriftUtils
) {

    inner class MoviePagingViewHolder(var binding : MovieAndTvShowSecondaryItemBinding): RecyclerView.ViewHolder(binding.root){

        init {

        }

        fun bind(){
            val data = getItem(layoutPosition)
            val length=data?.release_date?.length?:0
            if(length>0)
                binding.tvYearMovieTvShowSecondaryYear.text=data?.release_date?.substring(0,4)
            else
                binding.tvYearMovieTvShowSecondaryYear.text=data?.release_date
            binding.tvTitleMovieTvShowSecondaryName.text = data?.title
            binding.tvRetingMovieTvShowSecondary.text = data?.vote_average.toString()
            binding.ivImageMovieTvShowSecondary.load(IMAGE_BASE_URL_500+data?.poster_path,true)

            binding.clMovieTvShowSecondary.setOnClickListener(){
                binding.root.context.startActivity(MovieDetailActivity.getInstance(binding.root.context,data?.id.toString()))
            }
        }
    }

    override fun onBindViewHolder(holder: MoviePagingViewHolder, position: Int) =holder.bind()

    companion object DriftUtils : DiffUtil.ItemCallback<Movies>(){
        override fun areItemsTheSame(
            oldItem: Movies,
            newItem: Movies
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Movies,
            newItem: Movies
        ) = oldItem == newItem
    }

    interface OnItemClickListener {
        fun onItemClick(photo: Movies)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        MoviePagingViewHolder(MovieAndTvShowSecondaryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

}