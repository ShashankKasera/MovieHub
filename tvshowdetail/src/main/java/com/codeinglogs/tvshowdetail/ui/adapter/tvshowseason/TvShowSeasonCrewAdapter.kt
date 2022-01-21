package com.codeinglogs.tvshowdetail.ui.adapter.tvshowseason

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.presentation.model.person.personlist.Person
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.databinding.TvShowCrewItemBinding

class TvShowSeasonCrewAdapter() : ListAdapter<Person, TvShowSeasonCrewAdapter.TvShowSeasonCrewViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<Person>(){
        override fun areItemsTheSame(
            oldItem: Person,
            newItem: Person
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Person,
            newItem: Person
        ) = oldItem == newItem
    }

    override fun getItemCount(): Int {
        if(super.getItemCount()<8)
            return super.getItemCount()
        else
            return 8
    }

    inner class TvShowSeasonCrewViewHolder(var binding : TvShowCrewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)
            Log.i("jkjkkj", "bind: ${data.name}")
            binding.tvCrewNameTvShowInfo.text=data.name
            binding.tvCrewProfessionTvShowInfo.text=data.known_for_department
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = TvShowSeasonCrewViewHolder(TvShowCrewItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: TvShowSeasonCrewViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTTvShowClick(data : TvShow)
        fun onUTvShowClick()
    }

}