package com.codeinglogs.tvshowdetail.ui.adapter.tvshow

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.reviews.TvShowReviews
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.databinding.TvShowReviewItemBinding

class TvShowReviewAdapter() : ListAdapter<TvShowReviews, TvShowReviewAdapter.ViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<TvShowReviews>(){
        override fun areItemsTheSame(
            oldItem: TvShowReviews,
            newItem: TvShowReviews
        ) = oldItem.content == newItem.content

        override fun areContentsTheSame(
            oldItem: TvShowReviews,
            newItem: TvShowReviews
        ) = oldItem == newItem
    }


    inner class ViewHolder(var binding : TvShowReviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.tvAuthorReview.text=data.author
            Log.i("gkjnwk", "bind: ${data.author}")
            binding.tvContentReview.text=data.content
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(TvShowReviewItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTTvShowClick(data : TvShow)
        fun onUTvShowClick()
    }

}