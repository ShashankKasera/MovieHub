package com.codeinglogs.moviehub.fragmant

import androidx.fragment.app.viewModels
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviehub.activity.AppInfoActivity
import com.codeinglogs.moviehub.databinding.FragmentMenuBinding
import com.codeinglogs.presentation.viewmodel.pagingmovies.MoviesPagingViewModel


class MenuFragment : BaseFragment<MoviesPagingViewModel, FragmentMenuBinding>(){

    override val mViewModel: MoviesPagingViewModel by viewModels()

    override fun onBinding() {

        init()
    }

    private fun init() {
        mViewBinding.clAppInfoMenu.setOnClickListener(){
            startActivity(AppInfoActivity.getInstance(requireContext()))
        }
    }

    override fun getViewBinding() = FragmentMenuBinding.inflate(layoutInflater)



}