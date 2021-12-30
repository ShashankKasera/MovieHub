package com.codeinglogs.persondetails.ui.activity


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.viewModels
import com.codeinglogs.core.PicassoImageLoadingService
import com.codeinglogs.core.SliderAdapter
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviehub.constant.*
import com.codeinglogs.persondetails.databinding.ActivityPersonDetailsBinding
import com.codeinglogs.persondetails.ui.adapter.PersonDetailsViewPagerAdapter
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.person.persondetails.externalids.PersonExternalIdsResponse
import com.codeinglogs.presentation.model.person.persondetails.taggedimages.PersonTaggedImages
import com.codeinglogs.presentation.viewmodel.persondetail.PersonDetailViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ss.com.bannerslider.Slider

private const val TAG = "123PersonDetailsActivity"

@AndroidEntryPoint
class PersonDetailsActivity : BaseActivity<PersonDetailViewModel, ActivityPersonDetailsBinding>(){

    lateinit var personDetailsViewPagerAdapter: PersonDetailsViewPagerAdapter

    override val mViewModel:PersonDetailViewModel by viewModels()

    override fun getViewBinding()= ActivityPersonDetailsBinding.inflate(layoutInflater)

    override fun onBinding() {

        setUpTabBar()

        mViewModel.getPersonDetails("1136406")

        mViewModel.personDetails.observe(this){
            it.contentIfNotHandled?.let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i("gqnjjq", "Failed: PersonDetailsActivity ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i("gqnjjq", "Loading: PersonDetailsActivity ${it.data}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i("gqnjjq", "Success: PersonDetailsActivity ${it.data}")
                        showProgressBar(false)
                        addSlider(mViewBinding.bsPersonPersonDet,it.data.personTaggedImagesResponse.results)


                        setupExternalIds(it.data.personExternalIdsResponse)
                    }
                }
            }
        }
    }


    private fun setupExternalIds(personExternalIdsResponse: PersonExternalIdsResponse){
        val openURL = Intent(android.content.Intent.ACTION_VIEW)
        mViewBinding.ivFacebookPersonDet.setOnClickListener {


            openURL.data = Uri.parse(FACEBOOK_BASE_URL+personExternalIdsResponse.instagram_id)
            startActivity(openURL)
            personExternalIdsResponse.facebook_id
        }
        mViewBinding.ivImdbPesonDet.setOnClickListener {

            openURL.data = Uri.parse(IMDB_BASE_URL+personExternalIdsResponse.imdb_id)
            startActivity(openURL)
            personExternalIdsResponse.imdb_id

        }
        mViewBinding.ivInstagramPersonDet.setOnClickListener {

            openURL.data = Uri.parse(INSTAGRAM_BASE_URL+personExternalIdsResponse.instagram_id)
            startActivity(openURL)
            personExternalIdsResponse.instagram_id
        }
        mViewBinding.ivTwitterPersonDet.setOnClickListener {
            openURL.data = Uri.parse(TWITTER_BASE_URL+personExternalIdsResponse.twitter_id)
            startActivity(openURL)
            personExternalIdsResponse.twitter_id
        }
    }
    private  fun addSlider (slider: Slider, results: List<PersonTaggedImages>, ) {

        val list = ArrayList<String>()
        for (result in results) {
            list.add(IMAGE_BASE_URL_500 + result.file_path)
        }
        Slider.init(PicassoImageLoadingService());
        slider.setAdapter(SliderAdapter(list))
        slider.setInterval(10000)

    }

    private fun setUpTabBar(){
        personDetailsViewPagerAdapter=PersonDetailsViewPagerAdapter(supportFragmentManager,lifecycle)

        mViewBinding.vp2PersonDet.adapter=personDetailsViewPagerAdapter

        TabLayoutMediator(mViewBinding.tblPersonDet, mViewBinding.vp2PersonDet){tab,position->
            when(position){
                0-> tab.text="Info"
                1-> tab.text="Movies"
                2-> tab.text="Tv Shows"
            }
        }.attach()
    }
    companion object{
        fun getInstance(context: Context) = Intent(context, PersonDetailsActivity::class.java)
    }
}