package com.codeinglogs.moviehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.Event
import com.codeinglogs.presentation.viewmodel.trendingmovies.TrendingMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "123MainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val trendingMoviesViewModel : TrendingMoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trendingMoviesViewModel.trendingMoviesList.observe(this){ it ->
            it.contentIfNotHandled?.let { it ->
                when(it){
                    is State.Failed -> Log.i(TAG, "Failed: ${it.message}")
                    is State.Loading -> Log.i(TAG, "Loading: ${it.data}")
                    is State.Success -> Log.i(TAG, "Success: ${it.data}")
                }
            }
        }

    }
}