package com.codeinglogs.data.store.maylist.mymovielistdetails

import com.codeinglogs.data.repository.maylist.LocalMyMovieListData
import com.codeinglogs.data.repository.maylist.LocalMyMovieListDetailsData
import com.codeinglogs.data.store.maylist.mymovielist.MyMoviesListDataSore
import javax.inject.Inject

class MyMoviesListDetailsDataSoreImpl @Inject constructor(
    private val localMyMovieListDetailsData: LocalMyMovieListDetailsData
): MyMoviesListDetailsDataSore {
    override fun getLocalDataSource()=localMyMovieListDetailsData

}