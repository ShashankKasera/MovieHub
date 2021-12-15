package com.codeinglogs.presentation.viewmodel.trendingpersonweek

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.codeinglogs.domain.usecase.GetPagingTrendingPersonWeek
import com.codeinglogs.domain.usecase.GetTrendingPersonWeek
import com.codeinglogs.presentation.maper.toPresentationState
import com.codeinglogs.presentation.model.Event
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.trendingpersonweek.ResultTrendingPersonWeekList
import com.codeinglogs.presentation.model.trendingpersonweek.TrendingPersonWeekList
import com.codeinglogs.presentation.model.trendingpersonweek.toPresentationResultTrendingPersonWeekList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TrendingPersonWeekViewModel @Inject constructor(
    private val getTrendingPersonWeek : GetTrendingPersonWeek,
    private val getPagingTrendingPersonWeekUseCase : GetPagingTrendingPersonWeek
    ) : ViewModel() {

    private val _TrendingPersonWeekViewModel = MutableLiveData<Event<State<TrendingPersonWeekList>>>()
    val trendingPersonWeekViewModel : LiveData<Event<State<TrendingPersonWeekList>>>
        get() = _TrendingPersonWeekViewModel


    var trendingPersonWeekPaging  = getPagingTrendingPersonWeekUseCase().map {
        it.map {
            it.toPresentationResultTrendingPersonWeekList()
        }
    }.cachedIn(viewModelScope).asLiveData()

    fun getTrendingPersonWeekList(){
        viewModelScope.launch {
            getTrendingPersonWeek().collect {
                _TrendingPersonWeekViewModel.value=Event(it.toPresentationState())
            }
        }
    }

}