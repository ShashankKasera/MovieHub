package com.codeinglogs.tvshowdetail.ui.activity

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.presentation.model.tvshow.tvshowenum.TvShowType
import com.codeinglogs.presentation.viewmodel.pagingtvshow.TvShowPagingViewModel
import com.codeinglogs.tvshowdetail.R
import com.codeinglogs.tvshowdetail.databinding.ActivityTvShowPagingBinding
import com.codeinglogs.tvshowdetail.ui.fragment.tvshow.TvShowPagingFragmentArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowPagingActivity : BaseActivity<TvShowPagingViewModel, ActivityTvShowPagingBinding>() {

    private lateinit var navController: NavController

    override val mViewModel: TvShowPagingViewModel by viewModels()
    override fun getViewBinding() = ActivityTvShowPagingBinding.inflate(layoutInflater)

    override fun onBinding() {
        init()
    }

    private fun init(){
        val type = intent.getSerializableExtra(TYPE) as TvShowType

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController=navHostFragment.navController
        navController.setGraph(R.navigation.tv_show_nav_graph,TvShowPagingFragmentArgs(type,"").toBundle())
    }

    companion object{
        const val TYPE = "type"
        fun getInstance(context: Context,type : TvShowType) = Intent(context, TvShowPagingActivity::class.java).apply {
            putExtra(TYPE,type)
        }
    }
}