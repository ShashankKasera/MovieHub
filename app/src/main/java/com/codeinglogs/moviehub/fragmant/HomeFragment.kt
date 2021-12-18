package com.codeinglogs.moviehub.fragmant

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviehub.adapter.MoviesPrimaryAdapter
import com.codeinglogs.moviehub.adapter.PersonPrimaryAdapter
import com.codeinglogs.moviehub.adapter.TvShowsPrimaryAdapter
import com.codeinglogs.moviehub.databinding.FragmentHomeBinding
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "123HomeFragment"

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    private lateinit var trendingPerson: PersonPrimaryAdapter
    private lateinit var trendingMovie :MoviesPrimaryAdapter
    private lateinit var trendingTvShow :TvShowsPrimaryAdapter
    private lateinit var popularMovie :MoviesPrimaryAdapter
    private lateinit var popularTvShow :TvShowsPrimaryAdapter
    private lateinit var topRatedMovie :MoviesPrimaryAdapter
    private lateinit var topRatedTvShow :TvShowsPrimaryAdapter

    override val mViewModel: HomeViewModel by viewModels()
    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

    override fun onBinding() {


        init()

        trendingPersonSetUpAdapter()
        trendingMovieSetUpAdapter()
        trendingTvShowSetUpAdapter()
        popularMovieSetUpAdapter()
        popularTvShowSetUpAdapter()
        topRatedMovieSetUpAdapter()
        topRatedTvShowSetUpAdapter()

        setUpObserver()

    }

    private fun init() {
        mViewModel.getHome()
    }

    private fun setUpObserver() {
        mViewModel.homeDisplay.observe(this){
            it.contentIfNotHandled?.let { it->
                when(it){
                    is State.Failed -> {
                        Log.i(TAG, "onBinding: MultiList Failed ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i(TAG, "onBinding: MultiList Loading ${it.toString()}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i(TAG, "onBinding: MultiList Success ${it.data.toString()}")
                        showProgressBar(false)
                        trendingPerson.submitList(it.data.trendingPerson.results)
                        trendingMovie.submitList(it.data.trendingMovie.results)
                        trendingTvShow.submitList(it.data.trendingTvShow.results)
                        popularMovie.submitList(it.data.popularMovie.results)
                        popularTvShow.submitList(it.data.popularTvShow.results)
                        topRatedMovie.submitList(it.data.topRatedMovie.results)
                        topRatedTvShow.submitList(it.data.topRatedTvShow.results)
                    }
                }
            }
        }

    }

    private fun trendingPersonSetUpAdapter(){
        trendingPerson = PersonPrimaryAdapter()
        mViewBinding.rvTrendingPersonHome.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvTrendingPersonHome.adapter=this.trendingPerson

    }

    private fun trendingMovieSetUpAdapter(){
        trendingMovie = MoviesPrimaryAdapter()
        mViewBinding.rvTrendingMoviesHome.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvTrendingMoviesHome.adapter=this.trendingMovie

    }

    private fun trendingTvShowSetUpAdapter(){
        trendingTvShow = TvShowsPrimaryAdapter()
        mViewBinding.rvTrendingTvShowHome.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvTrendingTvShowHome.adapter=this.trendingTvShow

    }

    private fun popularMovieSetUpAdapter(){
        popularMovie = MoviesPrimaryAdapter()
        mViewBinding.rvPopularMoviesHome.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvPopularMoviesHome.adapter=this.popularMovie
    }

    private fun popularTvShowSetUpAdapter(){
        popularTvShow = TvShowsPrimaryAdapter()
        mViewBinding.rvPopularTvShowHome.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvPopularTvShowHome.adapter=this.popularTvShow
    }

    private fun topRatedMovieSetUpAdapter(){
        topRatedMovie = MoviesPrimaryAdapter()
        mViewBinding.rvTopratedMoviesHome.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvTopratedMoviesHome.adapter=this.topRatedMovie
    }

    private fun topRatedTvShowSetUpAdapter(){
        topRatedTvShow = TvShowsPrimaryAdapter()
        mViewBinding.rvTopratedTvShowHome.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvTopratedTvShowHome.adapter=this.topRatedTvShow
    }

}