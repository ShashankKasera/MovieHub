package com.codeinglogs.persondetails.ui.fragmet

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.core.extension.showToast
import com.codeinglogs.persondetails.databinding.FragmentPersonInfoBinding
import com.codeinglogs.persondetails.ui.adapter.PersonImagesAdapter
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.person.persondetails.info.PersonInfoResponse
import com.codeinglogs.presentation.viewmodel.persondetail.PersonDetailViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        initProgressBar(mViewBinding.personDetailLoader)
        setUpPersonImagesAdapter()
        onclick()
    }

    private fun onclick() {
        mViewBinding.imaBookmarkPersonInfo.setOnClickListener {
            mViewModel.getBookmarkPerson(mViewModel.personId.toLong())
        }
    }
    private fun setUpPersonImagesAdapter(){
        personImagesAdapter = PersonImagesAdapter()
        mViewBinding.rvPersonImagesPersonDet.layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvPersonImagesPersonDet.adapter=this.personImagesAdapter
    }

    private fun setUpInfo(personInfoResponse: PersonInfoResponse){
        mViewBinding.tvPersonBerthPersonDet.text=personInfoResponse.birthday
        mViewBinding.tvPersonDeathdayPersonDet.text="From "+personInfoResponse.birthday+"  "+personInfoResponse.deathday
        //mViewBinding.tvAlsoKnownAsPersonDet.text= if (personInfoResponse.also_known_as.size>0) personInfoResponse.also_known_as.get(0) else ""
        mViewBinding.tvPersonDesPersonDet.text= personInfoResponse.biography
    }

    private fun personInfoObserve(){

        mViewModel.personDetails.observe(this) {

            it.peekContent().let { it ->
                when (it) {
                    is State.Failed -> {
                        Log.i(TAG, "Failed: MovieDetailActivity ${it.message}")
                        showProgressBar(false)
                        showToast(it.message)
                    }
                    is State.Loading -> {
                        Log.i(TAG, "Loading: MovieDetailActivity ${it.data?.personMovieCreditsResponse?.credit?.isNotEmpty()}")
                        if(it.data!=null&&it.data?.personMovieCreditsResponse?.credit?.isNotEmpty() == true){
                            personImagesAdapter.submitList(it.data!!.personImagesResponse.profiles)
                            Log.i(TAG, "personInfoObserve: ${it.data!!.personImagesResponse.profiles.size}")
                            setUpInfo(it.data!!.personInfoResponse)
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
                            personImagesAdapter.submitList(it.data.personImagesResponse.profiles)
                            setUpInfo(it.data.personInfoResponse)
                        }

                    }
                }
            }
        }
        mViewModel.bookmarkPersons.observe(this){
            it.peekContent()?.let { it ->
                when(it){
                    is State.Failed -> {
                        Log.i(TAG, "Failed: 123InfoFragment ${it.message}")
                        showProgressBar(false)
                        showToast(it.message)
                    }
                    is State.Loading -> {

                    }
                    is State.Success -> {

                        Log.i("hkkbk", "movieInfoObserve: ")
                    }
                }
            }
        }
    }

}