package com.codeinglogs.moviehub.fragmant

import androidx.fragment.app.viewModels
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviehub.databinding.FragmentSearchMovieBinding
import com.codeinglogs.presentation.viewmodel.pagingmovies.MoviesPagingViewModel


class SearchMovieFragment : BaseFragment<MoviesPagingViewModel, FragmentSearchMovieBinding>(){

    override val mViewModel: MoviesPagingViewModel by viewModels()

    override fun onBinding() {

    }

    override fun getViewBinding() = FragmentSearchMovieBinding.inflate(layoutInflater)



}