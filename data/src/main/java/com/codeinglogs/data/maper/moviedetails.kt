package com.codeinglogs.data.maper

import com.codeinglogs.domain.model.State as Domain
import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.movies.moviedetail.MovieDetailsDisplay
import com.codeinglogs.data.model.movies.moviedetail.toDomainMovieDetailsDisplay

fun State<MovieDetailsDisplay>.toDomainState() =
    when(this){
        is State.Loading -> Domain.loading((this.data)?.toDomainMovieDetailsDisplay())
        is State.Failed -> Domain.failed(this.message)
        is State.Success -> Domain.success(this.data.toDomainMovieDetailsDisplay())
    }
