package com.codeinglogs.presentation.maper

import com.codeinglogs.domain.model.State as Domain
import com.codeinglogs.presentation.model.State
import com.codeinglogs.domain.model.movies.moviedetail.MovieDetailsDisplay
import com.codeinglogs.presentation.model.movies.moviedetail.toPresentationMovieDetailsDisplay

fun Domain<MovieDetailsDisplay>.toPresentationState()=
    when(this){
        is Domain.Loading->State.loading((this.data)?.toPresentationMovieDetailsDisplay())
        is Domain.Failed->State.Failed((this.message))
        is Domain.Success->State.Success(this.data.toPresentationMovieDetailsDisplay())
    }