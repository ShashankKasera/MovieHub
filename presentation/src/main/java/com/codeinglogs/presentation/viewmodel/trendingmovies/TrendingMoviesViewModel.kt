package com.codeinglogs.presentation.viewmodel.trendingmovies

import androidx.lifecycle.*
import androidx.paging.cachedIn
import androidx.paging.map
import com.codeinglogs.domain.usecase.GetMulti
import com.codeinglogs.domain.usecase.GetPagingTrendingMovies
import com.codeinglogs.presentation.model.person.PersonList
import com.codeinglogs.domain.usecase.GetPerson
import com.codeinglogs.presentation.model.Event
import com.codeinglogs.domain.usecase.GetTrendingMovies
import com.codeinglogs.presentation.maper.toPresentationState
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.multi.MultiApiResponse
import com.codeinglogs.presentation.model.trendingmovies.TrendingMoviesList
import com.codeinglogs.presentation.model.trendingmovies.toPresentationTrendingMoviesResult
import com.codeinglogs.presentation.model.trendingpersonweek.toPresentationResultTrendingPersonWeekList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TrendingMoviesViewModel @Inject constructor(
    private val getTrendingMovies : GetTrendingMovies,
    private val getPagingTrendingMoviesUseCase: GetPagingTrendingMovies,
    private val getMulti: GetMulti
    ) : ViewModel() {

    private val _trendingMoviesList = MutableLiveData<Event<State<TrendingMoviesList>>>()
    val trendingMoviesList : LiveData<Event<State<TrendingMoviesList>>>
       get() = _trendingMoviesList

    var trendingMovies  = getPagingTrendingMoviesUseCase().map {
        it.map {
            it.toPresentationTrendingMoviesResult()
        }
    }.cachedIn(viewModelScope).asLiveData()

    fun getTrendingMoviesList(){
        viewModelScope.launch {
            getTrendingMovies().collect {
                _trendingMoviesList.value = Event(it.toPresentationState())
            }
        }
    }


    private val _MultiList = MutableLiveData<Event<State<MultiApiResponse>>>()
    val MultiList : LiveData<Event<State<MultiApiResponse>>>
        get() = _MultiList

    fun getMultiList(){
        viewModelScope.launch {
            getMulti().collect {
                _MultiList.value = Event(it.toPresentationState())
            }
        }
    }


}