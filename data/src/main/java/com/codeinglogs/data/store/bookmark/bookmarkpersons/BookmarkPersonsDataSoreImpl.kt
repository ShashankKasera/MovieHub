package com.codeinglogs.data.store.bookmark.bookmarkpersons

import com.codeinglogs.data.repository.bookmark.LocalBookmarkPersonsData
import javax.inject.Inject

class BookmarkPersonsDataSoreImpl @Inject constructor(
    private val localBookmarkPersonsData: LocalBookmarkPersonsData
): BookmarkPersonsDataSore {
    override fun getLocalDataSource()=localBookmarkPersonsData

}