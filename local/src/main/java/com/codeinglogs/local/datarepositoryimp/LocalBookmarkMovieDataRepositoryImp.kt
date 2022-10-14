package com.codeinglogs.local.datarepositoryimp

import com.codeinglogs.data.model.movies.movieslist.MoviesListResponse
import com.codeinglogs.data.repository.bookmark.LocalBookmarkMoviesData
import com.codeinglogs.local.dao.MoviesDao
import com.codeinglogs.local.dao.bookmark.BookmarkMoviesDao
import com.codeinglogs.local.entity.Movies
import com.codeinglogs.local.entity.bookmark.BookmarkMovies
import com.codeinglogs.local.entity.toDataMovies
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocalBookmarkMovieDataRepositoryImp  @Inject constructor(
    private val bookmarkMoviesDao: BookmarkMoviesDao,
):LocalBookmarkMoviesData {
//    override suspend fun isBookmarkMoviesExist(bookmarkId: Long): Boolean {
//        return bookmarkMoviesDao.isBookmarkMoviesIsExist(bookmarkId)
//    }
//
//
//    override suspend fun updateBookmarkMovies(bookmarkId: Long) {
//        bookmarkMoviesDao.insert(BookmarkMovies(0,bookmarkId))
//    }
}