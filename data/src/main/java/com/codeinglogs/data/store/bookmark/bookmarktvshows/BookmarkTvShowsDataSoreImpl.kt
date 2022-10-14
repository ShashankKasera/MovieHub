package com.codeinglogs.data.store.bookmark.bookmarktvshows

import com.codeinglogs.data.repository.bookmark.LocalBookmarkTvShowsData
import javax.inject.Inject

class BookmarkTvShowsDataSoreImpl @Inject constructor(
    private val localBookmarkTvShowsData: LocalBookmarkTvShowsData
): BookmarkTvShowsDataSore {
    override fun getLocalDataSource()=localBookmarkTvShowsData
}