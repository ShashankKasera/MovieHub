package com.codeinglogs.moviehub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.moviedetails.databinding.MoviePagingItemBinding
import com.codeinglogs.presentation.model.movies.movieslist.Movies
import com.codeinglogs.presentation.model.person.personlist.Person

class Adapter(val action : Actions, val callback : (data : Int) -> Int) : ListAdapter<Person, Adapter.ViewHolder>(
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


    inner class ViewHolder(var binding : MoviePagingItemBinding) : RecyclerView.ViewHolder(binding.root) {
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

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(MoviePagingItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind()

    interface Actions {
        fun onTMovieClick(data : Movies)
        fun onUMovieClick()
    }

}