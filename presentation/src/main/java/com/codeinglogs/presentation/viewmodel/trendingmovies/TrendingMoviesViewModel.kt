package com.codeinglogs.presentation.viewmodel.trendingmovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeinglogs.presentation.model.Event
import com.codeinglogs.domain.usecase.GetTrendingMovies
import com.codeinglogs.presentation.maper.toPresentationState
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.trendingmovies.TrendingMoviesList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TrendingMoviesViewModel @Inject constructor(private val getTrendingMovies : GetTrendingMovies) : ViewModel() {

    private val _trendingMoviesList = MutableLiveData<Event<State<TrendingMoviesList>>>()
    val trendingMoviesList : LiveData<Event<State<TrendingMoviesList>>>
       get() = _trendingMoviesList

    fun getTrendingMoviesList(){
        viewModelScope.launch {
            getTrendingMovies().collect {
                _trendingMoviesList.value = Event(it.toPresentationState())
            }
        }
    }

}