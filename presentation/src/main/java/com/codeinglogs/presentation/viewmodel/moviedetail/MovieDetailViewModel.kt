package com.codeinglogs.presentation.viewmodel.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeinglogs.domain.usecase.GetMovieDetails
import com.codeinglogs.presentation.maper.toPresentationState
import com.codeinglogs.presentation.model.Event
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.movies.moviedetail.MovieDetailsDisplay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel@Inject constructor(private val getMovieDetailsUseCase: GetMovieDetails): ViewModel() {

    private val _MovieDetails = MutableLiveData<Event<State<MovieDetailsDisplay>>>()
    val movieDetails : LiveData<Event<State<MovieDetailsDisplay>>>
        get() = _MovieDetails


    fun getMovieDetails(id: String) {
        viewModelScope.launch {
            getMovieDetailsUseCase(id).collect{
                _MovieDetails.value=Event(it.toPresentationState())

            }
        }
    }
}