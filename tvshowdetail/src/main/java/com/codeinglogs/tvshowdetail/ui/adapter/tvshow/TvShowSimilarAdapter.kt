package com.codeinglogs.tvshowdetail.ui.adapter.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.databinding.TvShowItemBinding
import com.codeinglogs.tvshowdetail.ui.activity.TvShowDetailsActivity

class TvShowSimilarAdapter() : ListAdapter<TvShow, TvShowSimilarAdapter.TvShowSimilarViewHolder>(
    DriftUtils
){

    init {

    }

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


    inner class TvShowSimilarViewHolder(var binding : TvShowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.clTvShow.setOnClickListener {
                binding.root.context.startActivity(TvShowDetailsActivity.getInstance(binding.root.context,getItem(layoutPosition).id.toString()))
            }
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.ivTvShow.load(IMAGE_BASE_URL_500 +data.backdrop_path)
            binding.tvTvShowName.text=data.name
            binding.tvReting.text=data.vote_average.toString()
            if(data.first_air_date.length>0)
                binding.tvTvShowYear.text=data.first_air_date.substring(0,4)
            else
                binding.tvTvShowYear.text=data.first_air_date
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = TvShowSimilarViewHolder(TvShowItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: TvShowSimilarViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTTvShowClick(data : TvShow)
        fun onUMovieClick()
    }

}
