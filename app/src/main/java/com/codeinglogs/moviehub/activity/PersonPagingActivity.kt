package com.codeinglogs.moviehub.activity

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviehub.adapter.HomeLoadStateAdapter
import com.codeinglogs.moviehub.adapter.PersonPagingAdapter
import com.codeinglogs.moviehub.databinding.ActivityPersonPagingBinding
import com.codeinglogs.presentation.viewmodel.pagingperson.PersonPagingViewModel
import dagger.hilt.android.AndroidEntryPoint


private const val TAG = "123PersonPctivity"
@AndroidEntryPoint
class PersonPagingActivity : BaseActivity<PersonPagingViewModel, ActivityPersonPagingBinding>() {

    override val mViewModel: PersonPagingViewModel by viewModels()
    override fun getViewBinding() = ActivityPersonPagingBinding.inflate(layoutInflater)

    lateinit var personPagingAdapter: PersonPagingAdapter

    override fun onBinding() {
        init()
    }

    private fun personPagingObserve() {

        mViewModel.person.observe(this){
            personPagingAdapter.submitData(lifecycle,it)
        }
    }

    private fun init(){

        personPagingObserve()
        setUpPersonPagingAdapter()
        loadState()
        retry()
    }

    private fun retry() {
        mViewBinding.bRetryPersonPagingHome.setOnClickListener {
            personPagingAdapter.retry()
        }

    }

    private fun loadState() {
        personPagingAdapter.addLoadStateListener { loadState ->

            mViewBinding.apply {

                pbPersonPagingHome.isVisible = loadState.source.refresh is LoadState.Loading
                rvPersonPagingHome.isVisible = loadState.source.refresh is LoadState.NotLoading
                bRetryPersonPagingHome.isVisible = loadState.source.refresh is LoadState.Error

                // empty view
                if (loadState.source.refresh is LoadState.NotLoading &&
                    loadState.append.endOfPaginationReached &&
                    personPagingAdapter.itemCount < 1) {
                    rvPersonPagingHome.isVisible = false
                }
            }
        }
    }

    private fun setUpPersonPagingAdapter() {
        personPagingAdapter = PersonPagingAdapter()
        mViewBinding.rvPersonPagingHome.layoutManager= LinearLayoutManager(this)
        mViewBinding.rvPersonPagingHome.adapter=this.personPagingAdapter.withLoadStateHeaderAndFooter(
            header = HomeLoadStateAdapter { personPagingAdapter.retry() },
            footer = HomeLoadStateAdapter { personPagingAdapter.retry() },
        )
    }


    companion object{
        fun getInstance(context: Context) = Intent(context, PersonPagingActivity::class.java)
    }

}