package com.codeinglogs.data.store.bookmark

import com.codeinglogs.data.repository.bookmark.LocalBookmarkMoviesData
import com.codeinglogs.data.repository.moviedetails.LocalMovieDetailData
import com.codeinglogs.data.repository.moviedetails.RemoteMovieDetailData
import com.codeinglogs.data.store.moviedetails.MovieDetailsDataSore
import javax.inject.Inject

class BookmarkMoviesDataSoreImpl @Inject constructor(
    private val localBookmarkMoviesData: LocalBookmarkMoviesData
): BookmarkMoviesDataSore {
    override fun getLocalDataSource()=localBookmarkMoviesData

}