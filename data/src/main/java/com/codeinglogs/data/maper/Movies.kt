package com.codeinglogs.data.maper

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.movies.movieslist.MoviesListResponce
import com.codeinglogs.data.model.movies.movieslist.toDomainMoviesListResponce
import com.codeinglogs.domain.model.State as Domain

fun  State<MoviesListResponce>.toDomainState() =
     when(this){
        is State.Loading -> Domain.loading((this.data)?.toDomainMoviesListResponce())
        is State.Failed -> Domain.failed(this.message)
        is State.Success -> Domain.success(this.data.toDomainMoviesListResponce())
    }
