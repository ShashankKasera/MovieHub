package com.codeinglogs.moviehub

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.moviehub.databinding.MovieItemBinding
import com.codeinglogs.presentation.model.trendingpersonweek.ResultTrendingPersonWeekList
import com.codeinglogs.presentation.model.trendingtvshow.ResultTrendingTvShow

class Adapter(val action : Actions,val callback : (data : Int) -> Int) : ListAdapter<ResultTrendingPersonWeekList, Adapter.ViewHolder>(DriftUtils){

    init {

    }

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


    inner class ViewHolder(var binding : MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
//            binding.textView.setOnClickListener {
//                action.onTMovieClick(getItem(layoutPosition))
//            }
//            binding.textView2.setOnClickListener {
//                action.onUMovieClick()
//            }
//            binding.textView3.setOnClickListener {
//                var x = callback(10)
//            }
        }
        fun bind(){
            val data = getItem(layoutPosition)

            binding.textViewUserName.text = data.name
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(MovieItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind()

    interface Actions {
        fun onTMovieClick(data : ResultTrendingPersonWeekList)
        fun onUMovieClick()
    }

}