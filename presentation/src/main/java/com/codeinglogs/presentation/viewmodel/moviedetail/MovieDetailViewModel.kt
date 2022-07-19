package com.codeinglogs.presentation.viewmodel.moviedetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeinglogs.domain.usecase.GetBookmarkMovies
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
class MovieDetailViewModel@Inject constructor(private val getMovieDetailsUseCase: GetMovieDetails,private val getBookmarkMoviesUseCase: GetBookmarkMovies): ViewModel() {

    private val _MovieDetails = MutableLiveData<Event<State<MovieDetailsDisplay>>>()
    val movieDetails : LiveData<Event<State<MovieDetailsDisplay>>>
        get() = _MovieDetails

    private val _BookmarkMovies = MutableLiveData<Event<State<Boolean>>>()
    val bookmarkMovies : LiveData<Event<State<Boolean>>>
        get() = _BookmarkMovies

    var movieId=""

    fun getMovieDetails(id: String) {
        Log.i("sdmcdm", "getDetails: ")
        viewModelScope.launch {
            getMovieDetailsUseCase(id).collect{
                Log.i("sdmcdm", "getMovieDetails: $it")
                _MovieDetails.value=Event(it.toPresentationState())
            }
        }
    }
    fun getBookmarkMovies(id:Long){
        viewModelScope.launch {
            getBookmarkMoviesUseCase(id).collect {
                _BookmarkMovies.value=Event(it.toPresentationState())
            }
        }
    }
}