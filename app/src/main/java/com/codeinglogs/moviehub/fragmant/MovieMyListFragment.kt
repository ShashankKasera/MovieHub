package com.codeinglogs.moviehub.fragmant

import androidx.fragment.app.viewModels
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviehub.databinding.FragmentMovieMyListBinding
import com.codeinglogs.presentation.viewmodel.pagingmovies.MoviesPagingViewModel


class MovieMyListFragment : BaseFragment<MoviesPagingViewModel, FragmentMovieMyListBinding>(){

    override val mViewModel: MoviesPagingViewModel by viewModels()
    override fun getViewBinding() = FragmentMovieMyListBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
    }

    private fun init() {

    }




}