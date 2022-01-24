package com.codeinglogs.persondetails.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.persondetails.databinding.PersonLoadStateFooterBinding

class PersonPagingLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<PersonPagingLoadStateAdapter.PersonPagingLoadStateViewHolder>() {

    inner class PersonPagingLoadStateViewHolder(private val binding: PersonLoadStateFooterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.buttonRetry.setOnClickListener {
                retry.invoke()
            }
        }

        fun bind(loadState: LoadState) {
            binding.apply {
                progressBar.isVisible = loadState is LoadState.Loading
                buttonRetry.isVisible = loadState !is LoadState.Loading
                textViewError.isVisible = loadState !is LoadState.Loading
            }
        }
    }

    override fun onBindViewHolder(holder: PersonPagingLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): PersonPagingLoadStateViewHolder {
        val binding = PersonLoadStateFooterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PersonPagingLoadStateViewHolder(binding)
    }
}