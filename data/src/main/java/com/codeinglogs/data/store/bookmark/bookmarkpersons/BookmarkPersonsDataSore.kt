package com.codeinglogs.data.store.bookmark.bookmarkpersons

import com.codeinglogs.data.repository.bookmark.LocalBookmarkPersonsData

interface BookmarkPersonsDataSore {
    fun getLocalDataSource() : LocalBookmarkPersonsData
}