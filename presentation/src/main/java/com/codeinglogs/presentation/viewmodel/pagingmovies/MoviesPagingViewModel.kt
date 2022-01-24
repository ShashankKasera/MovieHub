package com.codeinglogs.presentation.viewmodel.pagingmovies

import androidx.lifecycle.*
import androidx.paging.cachedIn
import androidx.paging.map
import com.codeinglogs.domain.usecase.GetMoviesPaging
import com.codeinglogs.presentation.model.movies.movieenum.MovieType
import com.codeinglogs.presentation.model.movies.movieenum.toDomainMovieType
import com.codeinglogs.presentation.model.movies.movieslist.toPresentationMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@HiltViewModel
class MoviesPagingViewModel @Inject constructor(
    private val getMoviesPagingUseCase: GetMoviesPaging,
    ) : ViewModel() {

    fun getMoviesList(type : MovieType,id:String,movieSearch:String)  = getMoviesPagingUseCase(
        type.toDomainMovieType(),id,movieSearch
    ).map {
        it.map {
            it.toPresentationMovies()
        }
    }.cachedIn(viewModelScope).asLiveData()



}