package com.codeinglogs.moviehub.fragmant


import androidx.fragment.app.viewModels
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviehub.activity.MoviePagingActivity
import com.codeinglogs.moviehub.activity.PersonPagingActivity
import com.codeinglogs.moviehub.activity.SearchActivity
import com.codeinglogs.moviehub.activity.TvShowPagingActivity
import com.codeinglogs.moviehub.databinding.FragmentSearchBinding
import com.codeinglogs.presentation.model.movies.movieenum.MovieType
import com.codeinglogs.presentation.model.person.personenum.PersonType
import com.codeinglogs.presentation.model.tvshow.tvshowenum.TvShowType
import com.codeinglogs.presentation.viewmodel.pagingmovies.MoviesPagingViewModel

class SearchFragment : BaseFragment<MoviesPagingViewModel, FragmentSearchBinding>(){

    override val mViewModel: MoviesPagingViewModel by viewModels()

    override fun onBinding() {

        onClick()
    }

    private fun onClick() {
        mViewBinding.cvMovieTvPerson.setOnClickListener(){
            startActivity(SearchActivity.getInstance(requireContext()))
        }
        mViewBinding.etMovieTvPerson.setOnClickListener(){
            startActivity(SearchActivity.getInstance(requireContext()))
        }
        mViewBinding.cvMovie.setOnClickListener(){
            startActivity(MoviePagingActivity.getInstance(requireContext(), MovieType.TRENDING))
        }
        mViewBinding.cvTv.setOnClickListener(){
            startActivity(TvShowPagingActivity.getInstance(requireContext(), TvShowType.TRENDING))
        }
        mViewBinding.cvPerson.setOnClickListener(){
            startActivity(PersonPagingActivity.getInstance(requireContext(),PersonType.SEARCH))
        }
    }

    override fun getViewBinding() = FragmentSearchBinding.inflate(layoutInflater)



}