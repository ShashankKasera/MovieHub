package com.codeinglogs.moviehub.fragmant

import androidx.fragment.app.viewModels
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviehub.databinding.FragmentSearchTvShowBinding
import com.codeinglogs.presentation.viewmodel.pagingmovies.MoviesPagingViewModel


class SearchTvShowFragment : BaseFragment<MoviesPagingViewModel, FragmentSearchTvShowBinding>(){

    override  val mViewModel: MoviesPagingViewModel by viewModels()

    override fun onBinding() {

    }

    override fun getViewBinding() = FragmentSearchTvShowBinding.inflate(layoutInflater)



}