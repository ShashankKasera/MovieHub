package com.codeinglogs.presentation.viewmodel.tvshowdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeinglogs.domain.usecase.bookmark.GetBookmarkTvShows
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.TvShowDetailsDisplay
import com.codeinglogs.domain.usecase.GetTvShowDetails
import com.codeinglogs.domain.usecase.GetTvShowSeasonDetails
import com.codeinglogs.presentation.maper.toPresentationState
import com.codeinglogs.presentation.model.Event
import com.codeinglogs.presentation.model.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowDetailViewModel @Inject constructor(
    private val getTvShowDetailsUseCase: GetTvShowDetails,
    private val getTvShowSeasonDetailsUseCase: GetTvShowSeasonDetails,
    private val getBookmarkTvShowsUseCase: GetBookmarkTvShows
): ViewModel() {

    private val _TvShowDetails = MutableLiveData<Event<State<TvShowDetailsDisplay>>>()
    val tvShowDetails : LiveData<Event<State<TvShowDetailsDisplay>>>
        get() = _TvShowDetails

    private val _BookmarkTvShows = MutableLiveData<Event<State<Boolean>>>()
    val bookmarkTvShows : LiveData<Event<State<Boolean>>>
        get() = _BookmarkTvShows

    var tvShowId=""

    fun getTvShowDetails(id: String) {
        viewModelScope.launch {
            getTvShowDetailsUseCase(id).collect{
                _TvShowDetails.value=Event(it.toPresentationState())

            }
        }
    }

    fun getBookmarkTvShow(id:Long){
        viewModelScope.launch {
            getBookmarkTvShowsUseCase(id).collect {
                _BookmarkTvShows.value=Event(it.toPresentationState())
            }
        }
    }

}