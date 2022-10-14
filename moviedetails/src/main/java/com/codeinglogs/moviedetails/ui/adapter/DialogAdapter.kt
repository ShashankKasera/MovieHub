package com.codeinglogs.moviedetails.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.moviedetails.databinding.AddMovieItemBinding
import com.codeinglogs.presentation.model.movies.mylist.MyMovieListDisplay

class DialogAdapter(val callback : (data : Boolean,id :Long) -> Unit): ListAdapter<MyMovieListDisplay, DialogAdapter.ViewHolder>(
    DriftUtils
){

    init {


    }

    companion object DriftUtils : DiffUtil.ItemCallback<MyMovieListDisplay>(){
        override fun areItemsTheSame(
            oldItem: MyMovieListDisplay,
            newItem: MyMovieListDisplay
        ) = oldItem.myMovieListId == newItem.myMovieListId

        override fun areContentsTheSame(
            oldItem: MyMovieListDisplay,
            newItem: MyMovieListDisplay
        ) = oldItem == newItem
    }


    inner class ViewHolder(var binding : AddMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {


        }
        fun bind(){
            val data = getItem(layoutPosition)

            binding.textView.text = data.myMovieListName
            binding.checkBox.isChecked=data.flag

            binding.checkBox.setOnClickListener {
                callback(binding.checkBox.isChecked,data.myMovieListId)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(
        AddMovieItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind()


}