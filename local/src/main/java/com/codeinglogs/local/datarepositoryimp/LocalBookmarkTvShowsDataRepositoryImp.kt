package com.codeinglogs.local.datarepositoryimp

import com.codeinglogs.data.repository.bookmark.LocalBookmarkTvShowsData
import com.codeinglogs.local.dao.bookmark.BookmarkTvShowsDao
import com.codeinglogs.local.entity.bookmark.BookmarkTvShows
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocalBookmarkTvShowsDataRepositoryImp @Inject constructor(
    private val bookmarkTvShowsDao: BookmarkTvShowsDao,
): LocalBookmarkTvShowsData {
    override suspend fun isBookmarkTvShowsExist(BookmarkId: Long): Boolean {
        return bookmarkTvShowsDao.isBookmarkTvShowsIsExist(BookmarkId)
    }

    override suspend fun insertBookmarkTvShows(bookmarkId: Long) {
        coroutineScope{
            launch { bookmarkTvShowsDao.insert(BookmarkTvShows(0,bookmarkId)) }
        }
    }
}