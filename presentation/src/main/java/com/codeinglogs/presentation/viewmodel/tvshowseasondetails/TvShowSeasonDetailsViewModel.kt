package com.codeinglogs.presentation.viewmodel.tvshowseasondetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.TvShowSeasonDetailsDisplay
import com.codeinglogs.domain.usecase.GetTvShowSeasonDetails
import com.codeinglogs.presentation.maper.toPresentationState
import com.codeinglogs.presentation.model.Event
import com.codeinglogs.presentation.model.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowSeasonDetailsViewModel @Inject constructor(private val getTvShowSeasonDetailsUseCase: GetTvShowSeasonDetails): ViewModel() {

    private val _TvShowSeasonDetails = MutableLiveData<Event<State<TvShowSeasonDetailsDisplay>>>()
    val tvShowSeasonDetails : LiveData<Event<State<TvShowSeasonDetailsDisplay>>>
    get() = _TvShowSeasonDetails

    var tvShowSeasonId=""
    var tvShowSeasonNumber=-1

    fun getTvShowSeasonDetails(id: String,season_number:Int) {
        viewModelScope.launch {
            getTvShowSeasonDetailsUseCase(id,season_number).collect{
                _TvShowSeasonDetails.value= Event(it.toPresentationState())

            }
        }
    }
}