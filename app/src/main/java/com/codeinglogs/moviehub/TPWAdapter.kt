package com.codeinglogs.moviehub

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.databinding.MovieItemBinding
import com.codeinglogs.moviehub.databinding.TpwItemBinding
import com.codeinglogs.presentation.model.trendingpersonweek.ResultTrendingPersonWeekList
import com.squareup.picasso.Picasso

class TPWAdapter(): PagingDataAdapter<ResultTrendingPersonWeekList,TPWAdapter.TPWViewHolder>(DriftUtils) {

    inner class TPWViewHolder(var binding : TpwItemBinding): RecyclerView.ViewHolder(binding.root){

        init {

        }

        fun bind(){
            val data = getItem(layoutPosition)
            binding.textViewUserName.text = data?.name
            data?.profile_path?.let {
                binding.imageView.load("https://image.tmdb.org/t/p/w500"+it,true)
//                Picasso.get().load("https://image.tmdb.org/t/p/w500"+it).into(binding.imageView)
            }
        }
    }

    override fun onBindViewHolder(holder: TPWViewHolder, position: Int) =holder.bind()

    companion object DriftUtils : DiffUtil.ItemCallback<ResultTrendingPersonWeekList>(){
        override fun areItemsTheSame(
            oldItem: ResultTrendingPersonWeekList,
            newItem: ResultTrendingPersonWeekList
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: ResultTrendingPersonWeekList,
            newItem: ResultTrendingPersonWeekList
        ) = oldItem == newItem
    }

    interface OnItemClickListener {
        fun onItemClick(photo: ResultTrendingPersonWeekList)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        TPWViewHolder(TpwItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

}