package com.codeinglogs.presentation.viewmodel.trendingtvshow

import androidx.lifecycle.*
import androidx.paging.cachedIn
import androidx.paging.map
import com.codeinglogs.domain.usecase.GetPagingTrendingMovies
import com.codeinglogs.domain.usecase.GetPagingTrendingTvShow
import com.codeinglogs.domain.usecase.GetTrendingTvShow
import com.codeinglogs.presentation.maper.toPresentationState
import com.codeinglogs.presentation.model.Event
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.movies.movieslist.toPresentationMovies
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShowsListResponse
import com.codeinglogs.presentation.model.tvshow.tvshowslist.toPresentationTvShow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingTvShowViewModel @Inject constructor(
    private val getTrendingTvShow : GetTrendingTvShow,
    private val GetPagingTrendingTvShow: GetPagingTrendingTvShow,
    ) : ViewModel() {

    private val _TrendingTvShowViewModel = MutableLiveData<Event<State<TvShowsListResponse>>>()
    val trendingTvShowViewModel : LiveData<Event<State<TvShowsListResponse>>>
        get() = _TrendingTvShowViewModel

    var trendingTvShow  = GetPagingTrendingTvShow().map {
        it.map {
            it.toPresentationTvShow()
        }
    }.cachedIn(viewModelScope).asLiveData()

    fun getTrendingTvShowList(){
        viewModelScope.launch {
            getTrendingTvShow().collect {
                _TrendingTvShowViewModel.value = Event(it.toPresentationState())
            }
        }
    }


}