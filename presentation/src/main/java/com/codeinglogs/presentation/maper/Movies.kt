package com.codeinglogs.presentation.maper

import com.codeinglogs.domain.model.movies.movieslist.MoviesListResponse
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.movies.movieslist.toPresentationMoviesListResponse
import com.codeinglogs.domain.model.State as Domain

fun  Domain<MoviesListResponse>.toPresentationState() =
     when(this){
        is Domain.Loading -> State.loading((this.data)?.toPresentationMoviesListResponse())
        is Domain.Failed -> State.failed(this.message)
        is Domain.Success -> State.success(this.data.toPresentationMoviesListResponse())
    }

