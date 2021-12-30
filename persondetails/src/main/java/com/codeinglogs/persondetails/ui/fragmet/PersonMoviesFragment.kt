package com.codeinglogs.persondetails.ui.fragmet

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.persondetails.databinding.FragmentPersonMoviesBinding
import com.codeinglogs.persondetails.ui.adapter.PersonMovieCreditsAdapter
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.persondetail.PersonDetailViewModel

private const val TAG = "123PersonMoviesFragment"
class PersonMoviesFragment : BaseFragment<PersonDetailViewModel, FragmentPersonMoviesBinding>(){

    lateinit var personMovieCreditsAdapter: PersonMovieCreditsAdapter
    override val mViewModel: PersonDetailViewModel by activityViewModels()

    override fun getViewBinding() = FragmentPersonMoviesBinding.inflate(layoutInflater)

    override fun onBinding() {

        mViewModel.personDetails.observe(this) {

            it.peekContent().let { it ->
                when (it) {
                    is State.Failed -> {
                        Log.i(TAG, "Failed: MovieDetailActivity ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i(TAG, "Loading: MovieDetailActivity ${it.data}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i(TAG, "Success: MovieDetailActivity ${it.data}")

                        showProgressBar(false)

                        setUpPersonMoviesAdapter()
                        personMovieCreditsAdapter.submitList(it.data.personMovieCreditsResponse.credit)
                    }
                }
            }
        }
    }

    private fun setUpPersonMoviesAdapter() {
        personMovieCreditsAdapter = PersonMovieCreditsAdapter()
        mViewBinding.rvPersonMovie.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        mViewBinding.rvPersonMovie.adapter=this.personMovieCreditsAdapter
    }

}