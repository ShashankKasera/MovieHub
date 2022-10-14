package com.codeinglogs.local.datarepositoryimp

import com.codeinglogs.data.repository.bookmark.LocalBookmarkPersonsData
import com.codeinglogs.local.dao.bookmark.BookmarkPersonsDao
import com.codeinglogs.local.entity.bookmark.BookmarkPersons
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocalBookmarkPersonsDataRepositoryImp @Inject constructor(
    private val bookmarkPersonsDao: BookmarkPersonsDao,
): LocalBookmarkPersonsData {

    override suspend fun insertBookmarkPerson(bookmarkId: Long) {
        coroutineScope{
            launch { bookmarkPersonsDao.insert(BookmarkPersons(0,bookmarkId)) }
        }
    }
}