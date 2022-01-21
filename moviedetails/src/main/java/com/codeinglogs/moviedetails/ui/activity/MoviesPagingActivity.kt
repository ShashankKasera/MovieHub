package com.codeinglogs.moviedetails.ui.activity

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviedetails.R

import com.codeinglogs.moviedetails.databinding.ActivityMoviesPagingBinding
import com.codeinglogs.moviedetails.ui.fragment.MoviePagingFragmentArgs
import com.codeinglogs.presentation.model.movies.movieenum.MovieType
import com.codeinglogs.presentation.viewmodel.pagingmovies.MoviesPagingViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "1231viesActivity"

@AndroidEntryPoint
class MoviesPagingActivity : BaseActivity<MoviesPagingViewModel, ActivityMoviesPagingBinding>() {

    private lateinit var navController: NavController

    override val mViewModel: MoviesPagingViewModel by viewModels()
    override fun getViewBinding() = ActivityMoviesPagingBinding.inflate(layoutInflater)

    override fun onBinding() {
        init()
    }

    private fun init(){
        val type = intent.getSerializableExtra(TYPE) as MovieType
        Log.i(TAG, "init: $type")

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController=navHostFragment.navController
        navController.setGraph(R.navigation.movie_nav_graph,MoviePagingFragmentArgs(type).toBundle())
    }

    companion object{
        const val TYPE = "type"
        fun getInstance(context: Context,type : MovieType) = Intent(context, MoviesPagingActivity::class.java).apply {
            putExtra(TYPE,type)
        }
    }


}