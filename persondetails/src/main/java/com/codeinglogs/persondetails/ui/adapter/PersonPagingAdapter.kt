package com.codeinglogs.persondetails.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.persondetails.databinding.PersonPagingItemBinding
import com.codeinglogs.persondetails.ui.activity.PersonDetailsActivity
import com.codeinglogs.presentation.model.person.personlist.Person

class PersonPagingAdapter :
    PagingDataAdapter<Person, PersonPagingAdapter.PersonPagingViewHolder>(DriftUtils) {

    inner class PersonPagingViewHolder(var binding : PersonPagingItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind() {
            val data = getItem(layoutPosition)
            binding.tvName.text = data?.name
            data?.profile_path?.let {
                binding.ivPersonImage.load("https://image.tmdb.org/t/p/w500"+it,true)
            }
            binding.tvProfession.text=data?.known_for_department

            binding.clPerson.setOnClickListener(){
                binding.root.context.startActivity(PersonDetailsActivity.getInstance(binding.root.context,data?.id.toString()))
            }
        }

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
    override fun onBindViewHolder(holder: PersonPagingViewHolder, position: Int)  =holder.bind()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        PersonPagingViewHolder(PersonPagingItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

}