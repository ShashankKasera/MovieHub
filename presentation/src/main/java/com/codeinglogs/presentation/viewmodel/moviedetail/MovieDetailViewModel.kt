package com.codeinglogs.presentation.viewmodel.moviedetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeinglogs.domain.usecase.bookmark.UpdateBookmarkMovies
import com.codeinglogs.domain.usecase.GetMovieDetails
import com.codeinglogs.domain.usecase.mylist.InsertMyMovieList
import com.codeinglogs.domain.usecase.mylist.GetMyMovieListDetails
import com.codeinglogs.presentation.maper.toPresentationState
import com.codeinglogs.presentation.model.Event
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.movies.moviedetail.MovieDetailsDisplay
import com.codeinglogs.presentation.model.movies.mylist.MyMovieListDisplay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel@Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetails,
    private val updateBookmarkMoviesUseCase: UpdateBookmarkMovies,
    private val insertMyMovieListUseCase: InsertMyMovieList,
    private val getMyMovieListDetailsUseCase: GetMyMovieListDetails
): ViewModel() {

    private val _MovieDetails = MutableLiveData<Event<State<MovieDetailsDisplay>>>()
    val movieDetails : LiveData<Event<State<MovieDetailsDisplay>>>
        get() = _MovieDetails

    private val _BookmarkMovies = MutableLiveData<Event<State<Boolean>>>()
    val bookmarkMovies : LiveData<Event<State<Boolean>>>
        get() = _BookmarkMovies

    private val _MyMoviesList = MutableLiveData<Event<State<MyMovieListDisplay>>>()
    val myMoviesList : LiveData<Event<State<MyMovieListDisplay>>>
        get() = _MyMoviesList

    private val _MyMoviesListDetails = MutableLiveData<Event<State<Boolean>>>()
    val myMoviesListDetails : LiveData<Event<State<Boolean>>>
        get() = _MyMoviesListDetails
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
    fun updateBookmarkMovies(id:Long){
        viewModelScope.launch {
            updateBookmarkMoviesUseCase(id).collect {
                _BookmarkMovies.value=Event(it.toPresentationState())
            }
        }
    }

    fun insertMyMoviesList(movieId:String,name:String ){
        viewModelScope.launch {
            insertMyMovieListUseCase(name,movieId).collect {
                _MyMoviesList.value= Event(it.toPresentationState())
            }
        }
    }

    fun insertMyMoviesListDetails(myMovieListId:Long,movieId:Long ){
        viewModelScope.launch {
            getMyMovieListDetailsUseCase(myMovieListId,movieId).collect {
                _MyMoviesListDetails.value= Event(it.toPresentationState())
            }
        }
    }


}