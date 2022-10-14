package com.codeinglogs.data.store.bookmark.bookmarktvshows

import com.codeinglogs.data.repository.bookmark.LocalBookmarkTvShowsData

interface BookmarkTvShowsDataSore {
    fun getLocalDataSource() : LocalBookmarkTvShowsData
}