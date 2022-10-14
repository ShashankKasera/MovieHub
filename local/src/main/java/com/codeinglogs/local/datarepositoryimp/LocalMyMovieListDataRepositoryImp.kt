package com.codeinglogs.local.datarepositoryimp

import com.codeinglogs.data.repository.maylist.LocalMyMovieListData
import com.codeinglogs.local.dao.maylist.movie.MyMovieListDao
import com.codeinglogs.local.dao.maylist.movie.MyMovieListDetailsDao
import com.codeinglogs.local.entity.mylist.movie.MyMovieList
import com.codeinglogs.local.entity.mylist.movie.MyMovieListDetails
import com.codeinglogs.local.entity.mylist.movie.toDataMyMovieList
import javax.inject.Inject
import  com.codeinglogs.data.model.movies.mylist.MyMovieList as DataMyMovieList
class LocalMyMovieListDataRepositoryImp@Inject constructor(
    private val myMovieListDao: MyMovieListDao,
    private val myMovieListDetailsDao: MyMovieListDetailsDao,
): LocalMyMovieListData {
    override suspend fun insertMyMoviesList(name: String) :Long {
        return myMovieListDao.insert(MyMovieList(0, name))
    }

    override suspend fun insertMyMoviesListDetails(myMoviesListId: Long, movieId: Long): Long {
        return  myMovieListDetailsDao.insert(MyMovieListDetails(0,myMoviesListId,movieId))
    }

    override suspend fun getAllMyMoviesList(): List<DataMyMovieList> {
        return myMovieListDao.getAllMayMovieList().toDataMyMovieList()
    }


}