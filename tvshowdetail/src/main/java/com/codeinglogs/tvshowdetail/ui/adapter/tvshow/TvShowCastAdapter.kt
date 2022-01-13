package com.codeinglogs.tvshowdetail.ui.adapter.tvshow

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.credits.TvShowCast
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.tvshowdetail.databinding.TvShowPersonItemBinding
import com.codeinglogs.tvshowdetail.ui.activity.TvShowDetailsActivity

class TvShowCastAdapter() : ListAdapter<TvShowCast, TvShowCastAdapter.TvShowCastViewHolder>(
    DriftUtils
){

    init {

    }

    companion object DriftUtils : DiffUtil.ItemCallback<TvShowCast>(){
        override fun areItemsTheSame(
            oldItem: TvShowCast,
            newItem: TvShowCast
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: TvShowCast,
            newItem: TvShowCast
        ) = oldItem == newItem
    }


    inner class TvShowCastViewHolder(var binding : TvShowPersonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.clPerson.setOnClickListener {
              //  binding.root.context.startActivity(PersonDetailsActivity.getInstance(binding.root.context,getItem(layoutPosition).id.toString()))
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

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = TvShowCastViewHolder(TvShowPersonItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: TvShowCastViewHolder, position: Int) = viewHolder.bind(position)

    interface Actions {
        fun onTTvShowClick(data : TvShow)
        fun onUTvShowClick()
    }

}