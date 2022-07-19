package com.codeinglogs.data.store.bookmark

import com.codeinglogs.data.repository.bookmark.LocalBookmarkMoviesData

interface BookmarkMoviesDataSore {
    fun getLocalDataSource() : LocalBookmarkMoviesData
}