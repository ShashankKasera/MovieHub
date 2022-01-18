package com.codeinglogs.moviehub.fragmant

import androidx.fragment.app.viewModels
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviehub.databinding.FragmentSearchPersonBinding
import com.codeinglogs.presentation.viewmodel.pagingmovies.MoviesPagingViewModel


class SearchPersonFragment : BaseFragment<MoviesPagingViewModel, FragmentSearchPersonBinding>(){

    override val mViewModel: MoviesPagingViewModel by viewModels()

    override fun onBinding() {

    }

    override fun getViewBinding() = FragmentSearchPersonBinding.inflate(layoutInflater)



}