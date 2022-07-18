package com.codeinglogs.persondetails.ui.fragmet

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.core.extension.showToast
import com.codeinglogs.persondetails.databinding.FragmentPersonMoviesBinding
import com.codeinglogs.persondetails.ui.adapter.PersonMovieCreditsAdapter
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.persondetail.PersonDetailViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "123PersonMoviesFragment"
class PersonMoviesFragment : BaseFragment<PersonDetailViewModel, FragmentPersonMoviesBinding>(){

    lateinit var personMovieCreditsAdapter: PersonMovieCreditsAdapter

    override val mViewModel: PersonDetailViewModel by activityViewModels()
    override fun getViewBinding() = FragmentPersonMoviesBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
        personMoviesObserve()

    }

    private fun init() {
        initProgressBar(mViewBinding.personDetailMovieLoader)
        setUpPersonMoviesAdapter()
    }

    private fun personMoviesObserve() {
        mViewModel.personDetails.observe(this) {

            it.peekContent().let { it ->
                when (it) {
                    is State.Failed -> {
                        Log.i(TAG, "Failed: MovieDetailActivity ${it.message}")
                        showProgressBar(false)
                        showToast(it.message)
                    }
                    is State.Loading -> {
                        Log.i(TAG, "Loading: MovieDetailActivity ${it.data}")
                        if(it.data!=null&&it.data?.personMovieCreditsResponse?.credit?.isNotEmpty() == true){
                            personMovieCreditsAdapter.submitList(it.data!!.personMovieCreditsResponse.credit)
                            showProgressBar(false)
                        }
                        else{
                            showProgressBar(true)
                        }
                    }
                    is State.Success -> {
                        Log.i(TAG, "Success: MovieDetailActivity ${it.data}")

                        lifecycleScope.launch(Dispatchers.Main) {
                            showProgressBar(false)
                            personMovieCreditsAdapter.submitList(it.data.personMovieCreditsResponse.credit)
                        }

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