package com.codeinglogs.data.store.bookmark.bookmarkmovie

import com.codeinglogs.data.repository.bookmark.LocalBookmarkMoviesData

interface BookmarkMoviesDataSore {
    fun getLocalDataSource() : LocalBookmarkMoviesData
}