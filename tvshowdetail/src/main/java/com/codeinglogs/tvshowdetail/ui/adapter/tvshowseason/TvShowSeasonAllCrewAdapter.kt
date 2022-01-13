package com.codeinglogs.tvshowdetail.ui.adapter.tvshowseason

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCast
import com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCrew
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.databinding.TvShowPersonItemBinding

class TvShowSeasonAllCrewAdapter() : ListAdapter<TvShowSeasonsCrew, TvShowSeasonAllCrewAdapter.TvShowSeasonAllCrewViewHolder>(
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


    inner class TvShowSeasonAllCrewViewHolder(var binding : TvShowPersonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.clPerson.setOnClickListener {
               // binding.root.context.startActivity(PersonDetailsActivity.getInstance(binding.root.context,getItem(layoutPosition).id.toString()))
            }
        }
        fun bind(position: Int) {
            val data = getItem(layoutPosition)

            binding.ivProfileImage.load(IMAGE_BASE_URL_500+data.profile_path)
            binding.tvName.text=data.name
            binding.tvProfession.text=data.known_for_department

            Log.i("jgwk", "bind: ${data.known_for_department} ")
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = TvShowSeasonAllCrewViewHolder(TvShowPersonItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: TvShowSeasonAllCrewViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTTvShowClick(data : TvShow)
        fun onUTvShowClick()
    }

}