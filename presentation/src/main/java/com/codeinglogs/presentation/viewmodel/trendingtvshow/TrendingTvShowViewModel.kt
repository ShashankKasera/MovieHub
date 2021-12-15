package com.codeinglogs.presentation.viewmodel.trendingtvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeinglogs.domain.usecase.GetTrendingMovies
import com.codeinglogs.domain.usecase.GetTrendingTvShow
import com.codeinglogs.presentation.maper.toPresentationState
import com.codeinglogs.presentation.model.Event
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.trendingmovies.TrendingMoviesList
import com.codeinglogs.presentation.model.trendingtvshow.TrendingTvShowList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingTvShowViewModel @Inject constructor(private val getTrendingTvShow : GetTrendingTvShow) : ViewModel() {

    private val _TrendingTvShowViewModel = MutableLiveData<Event<State<TrendingTvShowList>>>()
    val trendingTvShowViewModel : LiveData<Event<State<TrendingTvShowList>>>
        get() = _TrendingTvShowViewModel


    fun getTrendingTvShowList(){
        viewModelScope.launch {
            getTrendingTvShow().collect {
                _TrendingTvShowViewModel.value = Event(it.toPresentationState())
            }
        }
    }


}