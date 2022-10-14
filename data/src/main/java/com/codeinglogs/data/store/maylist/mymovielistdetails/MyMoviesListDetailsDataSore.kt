package com.codeinglogs.data.store.maylist.mymovielistdetails

import com.codeinglogs.data.repository.maylist.LocalMyMovieListDetailsData

interface MyMoviesListDetailsDataSore {

    fun getLocalDataSource() : LocalMyMovieListDetailsData
}