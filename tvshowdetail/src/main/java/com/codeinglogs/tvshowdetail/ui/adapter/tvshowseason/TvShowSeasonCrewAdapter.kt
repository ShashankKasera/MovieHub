package com.codeinglogs.tvshowdetail.ui.adapter.tvshowseason

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCrew
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.databinding.TvShowCrewItemBinding

class TvShowSeasonCrewAdapter() : ListAdapter<TvShowSeasonsCrew, TvShowSeasonCrewAdapter.ViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<TvShowSeasonsCrew>(){
        override fun areItemsTheSame(
            oldItem: TvShowSeasonsCrew,
            newItem: TvShowSeasonsCrew
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: TvShowSeasonsCrew,
            newItem: TvShowSeasonsCrew
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