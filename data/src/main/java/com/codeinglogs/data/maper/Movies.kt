package com.codeinglogs.data.maper

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.movies.movieslist.MoviesListResponse
import com.codeinglogs.data.model.movies.movieslist.toDomainMoviesListResponse
import com.codeinglogs.domain.model.State as Domain

fun  State<MoviesListResponse>.toDomainState() =
     when(this){
        is State.Loading -> Domain.loading((this.data)?.toDomainMoviesListResponse())
        is State.Failed -> Domain.failed(this.message)
        is State.Success -> Domain.success(this.data.toDomainMoviesListResponse())
    }
