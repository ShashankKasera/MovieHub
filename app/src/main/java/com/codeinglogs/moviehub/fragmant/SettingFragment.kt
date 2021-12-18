package com.codeinglogs.moviehub.fragmant


import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviehub.databinding.FragmentSettingBinding
import com.codeinglogs.presentation.viewmodel.trendingmovies.TrendingMoviesViewModel


class SettingFragment : BaseFragment<TrendingMoviesViewModel, FragmentSettingBinding>(){

    override val mViewModel: TrendingMoviesViewModel by viewModels()

    override fun onBinding() {

    }

    override fun getViewBinding() = FragmentSettingBinding.inflate(layoutInflater)



}