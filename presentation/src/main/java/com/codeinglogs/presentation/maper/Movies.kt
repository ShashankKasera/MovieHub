package com.codeinglogs.presentation.maper

import com.codeinglogs.domain.model.movies.movieslist.MoviesListResponce
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.movies.movieslist.toPresentationMoviesListResponce
import com.codeinglogs.domain.model.State as Domain

fun  Domain<MoviesListResponce>.toPresentationState() =
     when(this){
        is Domain.Loading -> State.loading((this.data)?.toPresentationMoviesListResponce())
        is Domain.Failed -> State.failed(this.message)
        is Domain.Success -> State.success(this.data.toPresentationMoviesListResponce())
    }

