package com.codeinglogs.local.datarepositoryimp

import com.codeinglogs.data.model.movies.mylist.MyMovieListDisplay
import com.codeinglogs.data.repository.maylist.LocalMyMovieListDetailsData
import com.codeinglogs.local.dao.maylist.movie.MyMovieListDetailsDao
import com.codeinglogs.local.entity.mylist.movie.MyMovieListDetails
import com.codeinglogs.local.entity.mylist.movie.toDataMyMovieListDetailsList
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

import com.codeinglogs.data.model.movies.mylist.MyMovieListDetails as DataMyMovieListDetails
class LocalMyMovieListDetailsDataRepositoryImp @Inject constructor(
    private val myMovieListDetailsDao: MyMovieListDetailsDao,
): LocalMyMovieListDetailsData {
    override suspend fun insertMyMoviesListDetails(myMovieListId: Long, movieId: Long) {
        myMovieListDetailsDao.insert(MyMovieListDetails(0, myMovieListId, movieId))
    }

    override suspend fun getMyMoviesListDetails(
        myMovieListId: Long,
        movieId: Long
    ): List<DataMyMovieListDetails> {
        return myMovieListDetailsDao.getMyMovieListDetails(myMovieListId, movieId).toDataMyMovieListDetailsList()
    }


}