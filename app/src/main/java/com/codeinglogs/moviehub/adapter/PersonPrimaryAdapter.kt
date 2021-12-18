package com.codeinglogs.moviehub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.moviehub.databinding.PerosnPrimaryItemBinding
import com.codeinglogs.presentation.model.movies.movieslist.Movies
import com.codeinglogs.presentation.model.person.personlist.Person

class PersonPrimaryAdapter : ListAdapter<Person, PersonPrimaryAdapter.PersonPrimaryViewHolder>(DriftUtils) {

    companion object DriftUtils : DiffUtil.ItemCallback<Person>(){
        override fun areItemsTheSame(
            oldItem: Person,
            newItem: Person
        
        )= oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Person,
            newItem: Person
        )= oldItem == newItem

    }

    inner class PersonPrimaryViewHolder(var binding : PerosnPrimaryItemBinding) : RecyclerView.ViewHolder(binding.root) {
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

            binding.tvPerson.text = data.name
            binding.ivPersonImage.load(IMAGE_BASE_URL_500 +data.profile_path,true)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = PersonPrimaryViewHolder(PerosnPrimaryItemBinding.inflate(
        LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: PersonPrimaryAdapter.PersonPrimaryViewHolder, position: Int) = viewHolder.bind()

}