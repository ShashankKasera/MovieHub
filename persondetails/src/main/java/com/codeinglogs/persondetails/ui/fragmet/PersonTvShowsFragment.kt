package com.codeinglogs.persondetails.ui.fragmet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.persondetails.R
import com.codeinglogs.persondetails.databinding.FragmentPersonInfoBinding
import com.codeinglogs.persondetails.databinding.FragmentPersonMoviesBinding
import com.codeinglogs.persondetails.databinding.FragmentPersonTvShowsBinding
import com.codeinglogs.persondetails.ui.adapter.PersonMovieCreditsAdapter
import com.codeinglogs.persondetails.ui.adapter.PersonTvCreditsAdapter
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel
import com.codeinglogs.presentation.viewmodel.persondetail.PersonDetailViewModel

private const val TAG = "123PersonTvShowsFragment"
class PersonTvShowsFragment : BaseFragment<PersonDetailViewModel, FragmentPersonTvShowsBinding>(){

    lateinit var personTvCreditsAdapter: PersonTvCreditsAdapter
    override val mViewModel: PersonDetailViewModel by activityViewModels()

    override fun getViewBinding() = FragmentPersonTvShowsBinding.inflate(layoutInflater)

    override fun onBinding() {

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

                        setUpPersonTvAdapter()
                        personTvCreditsAdapter.submitList(it.data.personTvCreditsResponse.credit)
                    }
                }
            }
        }
    }

    private fun setUpPersonTvAdapter() {
        personTvCreditsAdapter = PersonTvCreditsAdapter()
        mViewBinding.rvPersonTv.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        mViewBinding.rvPersonTv.adapter=this.personTvCreditsAdapter
    }
}