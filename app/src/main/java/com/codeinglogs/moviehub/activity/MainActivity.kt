package com.codeinglogs.moviehub.activity

import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviehub.adapter.Adapter
import com.codeinglogs.moviehub.databinding.ActivityMainBinding
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.movies.movieslist.Movies
import com.codeinglogs.presentation.viewmodel.personviewmodel.PersonViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "123MainActivity"

@AndroidEntryPoint
class MainActivity : BaseActivity<PersonViewModel, ActivityMainBinding>() {

    override val mViewModel:PersonViewModel by viewModels()
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    lateinit var adapter: Adapter

    override fun onBinding() {

        mViewModel.getPersonList()

        mViewModel.personList.observe(this){
            it.contentIfNotHandled?.let{it ->
                when(it){
                    is State.Failed -> showProgressBar(false)
                    is State.Loading -> showProgressBar(true)
                    is State.Success -> {
                        Log.i(TAG, "onBinding: ${it.data.results}")
                        showProgressBar(false)
                        adapter.submitList(it.data.results)
                    }
                }
            }
        }



        adapter = Adapter(object : Adapter.Actions{

            override fun onTMovieClick(data: Movies) {
                TODO("Not yet implemented")
            }

            override fun onUMovieClick() {

            }
        }) {
            10
        }

        mViewBinding.recyclerView.layoutManager=LinearLayoutManager(this)
        mViewBinding.recyclerView.adapter=this.adapter
        initProgressBar(mViewBinding.loader)

    }

}