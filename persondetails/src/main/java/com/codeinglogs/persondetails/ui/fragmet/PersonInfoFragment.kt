package com.codeinglogs.persondetails.ui.fragmet

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.persondetails.databinding.FragmentPersonInfoBinding
import com.codeinglogs.persondetails.ui.adapter.PersonImagesAdapter
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.person.persondetails.info.PersonInfoResponse
import com.codeinglogs.presentation.viewmodel.persondetail.PersonDetailViewModel

private const val TAG = "123PersonInfoFragment"

class PersonInfoFragment : BaseFragment<PersonDetailViewModel, FragmentPersonInfoBinding>(){

    lateinit var personImagesAdapter: PersonImagesAdapter
    override val mViewModel: PersonDetailViewModel by activityViewModels()

    override fun getViewBinding() = FragmentPersonInfoBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
        personInfoObserve()
    }

    private fun init() {
        setUpPersonImagesAdapter()
    }

    private fun setUpPersonImagesAdapter(){
        personImagesAdapter = PersonImagesAdapter()
        mViewBinding.rvPersonImagesPersonDet.layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvPersonImagesPersonDet.adapter=this.personImagesAdapter
    }

    private fun setUpInfo(personInfoResponse: PersonInfoResponse){
        mViewBinding.tvPersonBerthPersonDet.text=personInfoResponse.birthday
        mViewBinding.tvPersonDeathdayPersonDet.text="From "+personInfoResponse.birthday+"  "+personInfoResponse.deathday
        mViewBinding.tvAlsoKnownAsPersonDet.text= if (personInfoResponse.also_known_as.size>0) personInfoResponse.also_known_as.get(0) else ""
        mViewBinding.tvPersonDesPersonDet.text= personInfoResponse.biography
    }

    private fun personInfoObserve(){

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
                        personImagesAdapter.submitList(it.data.personImagesResponse.profiles)
                        setUpInfo(it.data.personInfoResponse)
                    }
                }
            }
        }
    }

}