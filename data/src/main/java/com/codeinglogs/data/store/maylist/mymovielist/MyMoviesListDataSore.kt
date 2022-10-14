package com.codeinglogs.data.store.maylist.mymovielist

import com.codeinglogs.data.repository.maylist.LocalMyMovieListData

interface MyMoviesListDataSore {
    fun getLocalDataSource() : LocalMyMovieListData

}