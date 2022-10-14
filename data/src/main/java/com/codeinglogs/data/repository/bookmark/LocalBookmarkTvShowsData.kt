package com.codeinglogs.data.repository.bookmark

interface LocalBookmarkTvShowsData {
    suspend fun isBookmarkTvShowsExist(Bookmark: Long): Boolean
    suspend fun insertBookmarkTvShows(Bookmark: Long)
}