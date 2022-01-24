package com.codeinglogs.persondetails.ui.fragmet

import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.persondetails.databinding.FragmentPersonPagingBinding
import com.codeinglogs.persondetails.ui.adapter.PersonPagingAdapter
import com.codeinglogs.persondetails.ui.adapter.PersonPagingLoadStateAdapter
import com.codeinglogs.presentation.model.person.personenum.PersonType
import com.codeinglogs.presentation.viewmodel.pagingperson.PersonPagingViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "123PersonTvShowsFragment"
@AndroidEntryPoint
class PersonPagingFragment : BaseFragment<PersonPagingViewModel, FragmentPersonPagingBinding>(){

    lateinit var personPagingAdapter: PersonPagingAdapter
    private val args: PersonPagingFragmentArgs by navArgs()
    override val mViewModel: PersonPagingViewModel by activityViewModels()
    override fun getViewBinding() = FragmentPersonPagingBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
        buttonRetry()
        pagingLoadState()

    }

    private fun init(){
        val type = args.personType
        val personSearch = args.personSearch
        Log.i("dscnsbdcb", "init: $type")
        setUpPersonPagingAdapter()
        personPagingObserve(type,personSearch)
    }

    private fun setUpPersonPagingAdapter(){
        personPagingAdapter = PersonPagingAdapter()
        mViewBinding.rvPersonPaging.layoutManager = LinearLayoutManager(context)
        mViewBinding.rvPersonPaging.adapter = this.personPagingAdapter.withLoadStateHeaderAndFooter(
            header = PersonPagingLoadStateAdapter { personPagingAdapter.retry() },
            footer = PersonPagingLoadStateAdapter { personPagingAdapter.retry() },
        )
    }

    private fun personPagingObserve(type: PersonType, personSearch: String) {
        mViewModel.getPersonList(type,personSearch).observe(this) {
            personPagingAdapter.submitData(lifecycle, it)
        }
    }

    private fun buttonRetry(){
        mViewBinding.bRetryPersonPaging.setOnClickListener {
            personPagingAdapter.retry()
        }
    }

    private fun pagingLoadState(){
        personPagingAdapter.addLoadStateListener { loadState ->

            mViewBinding.apply {
                pbPersonPaging.isVisible = loadState.source.refresh is LoadState.Loading
                rvPersonPaging.isVisible = loadState.source.refresh is LoadState.NotLoading
                bRetryPersonPaging.isVisible = loadState.source.refresh is LoadState.Error
                tvErrorPersonPaging.isVisible = loadState.source.refresh is LoadState.Error

                // empty view
                if (loadState.source.refresh is LoadState.NotLoading &&
                    loadState.append.endOfPaginationReached &&
                    personPagingAdapter.itemCount < 1
                ) {
                    rvPersonPaging.isVisible = false
                    tvErrorPersonPaging.isVisible = true
                } else {
                    tvErrorPersonPaging.isVisible = false
                }
            }
        }
    }


    companion object {
        fun newInstance(bundle: Bundle): PersonPagingFragment {
            val fragment = PersonPagingFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


}