package com.codeinglogs.presentation.maper


import com.codeinglogs.domain.model.movies.mylist.MyMovieListDisplay
import com.codeinglogs.domain.model.State as Domain
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.movies.mylist.toPresentationMyMovieListDisplay

fun Domain<MyMovieListDisplay>.toPresentationState()=
    when(this){
        is Domain.Loading->State.loading((this.data)?.toPresentationMyMovieListDisplay())
        is Domain.Failed->State.Failed((this.message))
        is Domain.Success->State.Success(this.data.toPresentationMyMovieListDisplay())
    }