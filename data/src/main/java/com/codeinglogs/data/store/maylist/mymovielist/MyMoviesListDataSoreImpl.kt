package com.codeinglogs.data.store.maylist.mymovielist

import com.codeinglogs.data.repository.maylist.LocalMyMovieListData
import javax.inject.Inject

class MyMoviesListDataSoreImpl @Inject constructor(
    private val localMayMovieListData: LocalMyMovieListData
): MyMoviesListDataSore {
    override fun getLocalDataSource()=localMayMovieListData

}