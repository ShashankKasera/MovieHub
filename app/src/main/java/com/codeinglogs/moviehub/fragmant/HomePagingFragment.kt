package com.codeinglogs.moviehub.fragmant

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.presentation.model.tvshow.tvshowenum.TvShowType
import com.codeinglogs.presentation.viewmodel.pagingtvshow.TvShowPagingViewModel
import com.codeinglogs.tvshowdetail.databinding.FragmentTvShowPagingBinding
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowLoadStateAdapter
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowPagingAdapter
import com.codeinglogs.tvshowdetail.ui.fragment.tvshow.TvShowPagingFragmentArgs


class HomePagingFragment : BaseFragment<TvShowPagingViewModel, FragmentTvShowPagingBinding>() {

    private lateinit var tvShowPagingAdapter: TvShowPagingAdapter
    private val args: TvShowPagingFragmentArgs by navArgs()

    override val mViewModel: TvShowPagingViewModel by activityViewModels()
    override fun getViewBinding() = FragmentTvShowPagingBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
        buttonRetry()
        pagingLoadState()
    }


    private fun init(){
        val type = args.tvShowType
        val id = args.tvShowId
        val tvShowSearch = args.tvShowSearch
        Log.i("kjkk", "init: $type")
        setUpTvShowPagingAdapter()
        tvShowPagingObserve(type,id,tvShowSearch)
    }

    private fun setUpTvShowPagingAdapter(){
        tvShowPagingAdapter = TvShowPagingAdapter()
        mViewBinding.rvTvShowPaging.layoutManager = LinearLayoutManager(context)
        mViewBinding.rvTvShowPaging.adapter = this.tvShowPagingAdapter.withLoadStateHeaderAndFooter(
            header = TvShowLoadStateAdapter { tvShowPagingAdapter.retry() },
            footer = TvShowLoadStateAdapter { tvShowPagingAdapter.retry() },
        )
    }

    private fun tvShowPagingObserve(type: TvShowType, id: String, tvShowSearch: String) {

        mViewModel.getTvShowList(type,id,tvShowSearch).observe(this) {
            tvShowPagingAdapter.submitData(lifecycle, it)
        }
    }

    private fun buttonRetry(){
        mViewBinding.bRetryTvShowPaging.setOnClickListener {
            tvShowPagingAdapter.retry()
        }
    }

    private fun pagingLoadState(){
        tvShowPagingAdapter.addLoadStateListener { loadState ->

            mViewBinding.apply {

                pbTvShowPaging.isVisible = loadState.source.refresh is LoadState.Loading
                rvTvShowPaging.isVisible = loadState.source.refresh is LoadState.NotLoading
                bRetryTvShowPaging.isVisible = loadState.source.refresh is LoadState.Error
                tvErrorTvShowPaging.isVisible = loadState.source.refresh is LoadState.Error

                // empty view
                if (loadState.source.refresh is LoadState.NotLoading &&
                    loadState.append.endOfPaginationReached &&
                    tvShowPagingAdapter.itemCount < 1
                ) {
                    rvTvShowPaging.isVisible = false
                    tvErrorTvShowPaging.isVisible = true
                } else {
                    tvErrorTvShowPaging.isVisible = false
                }
            }


        }

    }
}