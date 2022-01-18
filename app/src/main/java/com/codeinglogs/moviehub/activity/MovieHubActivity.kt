package com.codeinglogs.moviehub.activity

import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviehub.R
import com.codeinglogs.moviehub.databinding.ActivityMovieHubBinding
import com.codeinglogs.presentation.viewmodel.pagingmovies.MoviesPagingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieHubActivity : BaseActivity<MoviesPagingViewModel, ActivityMovieHubBinding>() {

    private lateinit var navController: NavController

    override val mViewModel: MoviesPagingViewModel by viewModels()
    override fun getViewBinding() = ActivityMovieHubBinding.inflate(layoutInflater)

    override fun onBinding() {
        mViewBinding.tbHome.setTitle("Home")
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController=navHostFragment.navController
        //setupActionBarWithNavController(navController)
        mViewBinding.bottomNavView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()||super.onSupportNavigateUp()
    }

}