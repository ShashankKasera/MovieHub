package com.codeinglogs.tvshowdetail.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.credits.TvShowCrew
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.databinding.TvShowCrewItemBinding

class TvShowCrewAdapter() : ListAdapter<TvShowCrew, TvShowCrewAdapter.ViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<TvShowCrew>(){
        override fun areItemsTheSame(
            oldItem: TvShowCrew,
            newItem: TvShowCrew
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: TvShowCrew,
            newItem: TvShowCrew
        ) = oldItem == newItem
    }

    override fun getItemCount(): Int {
        if(super.getItemCount()<8)
            return super.getItemCount()
        else
            return 8
    }

    inner class ViewHolder(var binding : TvShowCrewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)
            Log.i("jkjkkj", "bind: ${data.name}")
            binding.tvCrewNameTvShowInfo.text=data.name
            binding.tvCrewProfessionTvShowInfo.text=data.known_for_department
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(TvShowCrewItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTTvShowClick(data : TvShow)
        fun onUTvShowClick()
    }

}