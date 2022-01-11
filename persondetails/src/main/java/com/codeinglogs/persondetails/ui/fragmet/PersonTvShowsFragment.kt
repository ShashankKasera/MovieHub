package com.codeinglogs.persondetails.ui.fragmet

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.persondetails.databinding.FragmentPersonTvShowsBinding
import com.codeinglogs.persondetails.ui.adapter.PersonTvCreditsAdapter
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.persondetail.PersonDetailViewModel

private const val TAG = "123PersonTvShowsFragment"
class PersonTvShowsFragment : BaseFragment<PersonDetailViewModel, FragmentPersonTvShowsBinding>(){

    lateinit var personTvCreditsAdapter: PersonTvCreditsAdapter

    override val mViewModel: PersonDetailViewModel by activityViewModels()
    override fun getViewBinding() = FragmentPersonTvShowsBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
        personTvShowsObserve()

    }

    private fun personTvShowsObserve() {
        mViewModel.personDetails.observe(this) {

            it.peekContent().let { it ->
                when (it) {
                    is State.Failed -> {
                        Log.i("kjfq", "Failed: MovieDetailActivity ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i("kjfq", "Loading: MovieDetailActivity ${it.data}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i("kjfq", "Success: MovieDetailActivity ${it.data}")

                        showProgressBar(false)
                        personTvCreditsAdapter.submitList(it.data.personTvCreditsResponse.credit)
                    }
                }
            }
        }
    }

    private fun init(){
        setUpPersonTvAdapter()
    }
    private fun setUpPersonTvAdapter() {
        personTvCreditsAdapter = PersonTvCreditsAdapter()
        mViewBinding.rvPersonTv.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        mViewBinding.rvPersonTv.adapter=this.personTvCreditsAdapter
    }
}