package com.codeinglogs.data.store.bookmark.bookmarkmovie

import com.codeinglogs.data.repository.bookmark.LocalBookmarkMoviesData
import javax.inject.Inject

class BookmarkMoviesDataSoreImpl @Inject constructor(
    private val localBookmarkMoviesData: LocalBookmarkMoviesData
): BookmarkMoviesDataSore {
    override fun getLocalDataSource()=localBookmarkMoviesData

}