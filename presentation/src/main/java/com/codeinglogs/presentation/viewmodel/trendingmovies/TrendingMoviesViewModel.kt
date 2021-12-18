package com.codeinglogs.presentation.viewmodel.trendingmovies

import androidx.lifecycle.*
import androidx.paging.cachedIn
import androidx.paging.map
import com.codeinglogs.domain.usecase.GetHome
import com.codeinglogs.domain.usecase.GetPagingTrendingMovies
import com.codeinglogs.presentation.model.Event
import com.codeinglogs.domain.usecase.GetTrendingMovies
import com.codeinglogs.presentation.maper.toPresentationState
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.movies.movieslist.MoviesListResponce
import com.codeinglogs.presentation.model.movies.movieslist.toPresentationMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TrendingMoviesViewModel @Inject constructor(
    private val getTrendingMoviesUseCase : GetTrendingMovies,
    private val getPagingTrendingMoviesUseCase: GetPagingTrendingMovies,
    ) : ViewModel() {

    private val _trendingMoviesList = MutableLiveData<Event<State<MoviesListResponce>>>()
    val trendingMoviesList : LiveData<Event<State<MoviesListResponce>>>
       get() = _trendingMoviesList

    var trendingMovies  = getPagingTrendingMoviesUseCase().map {
        it.map {
            it.toPresentationMovies()
        }
    }.cachedIn(viewModelScope).asLiveData()

    fun getTrendingMoviesList(){
        viewModelScope.launch {
            getTrendingMoviesUseCase().collect {
                _trendingMoviesList.value = Event(it.toPresentationState())
            }
        }
    }


}