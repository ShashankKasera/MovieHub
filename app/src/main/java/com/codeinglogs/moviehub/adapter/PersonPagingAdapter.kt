package com.codeinglogs.moviehub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.moviehub.databinding.PersonSecondaryItemBinding
import com.codeinglogs.persondetails.ui.activity.PersonDetailsActivity
import com.codeinglogs.presentation.model.person.personlist.Person
import com.codeinglogs.tvshowdetail.ui.activity.TvShowDetailsActivity

class PersonPagingAdapter(): PagingDataAdapter<Person, PersonPagingAdapter.MoviePagingViewHolder>(
    DriftUtils
) {

    inner class MoviePagingViewHolder(var binding : PersonSecondaryItemBinding): RecyclerView.ViewHolder(binding.root){

        init {

        }

        fun bind(){
            val data = getItem(layoutPosition)
            binding.tvName.text = data?.name
            binding.tvProfession.text = data?.known_for_department
            binding.ivProfileImage.load(IMAGE_BASE_URL_500+data?.profile_path,true)

            binding.clPerson.setOnClickListener(){
                binding.root.context.startActivity(PersonDetailsActivity.getInstance(binding.root.context,data?.id.toString()))
            }
        }
    }

    override fun onBindViewHolder(holder: MoviePagingViewHolder, position: Int) =holder.bind()

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

    interface OnItemClickListener {
        fun onItemClick(photo: Person)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        MoviePagingViewHolder(PersonSecondaryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

}