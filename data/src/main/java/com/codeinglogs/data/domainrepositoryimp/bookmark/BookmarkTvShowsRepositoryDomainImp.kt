package com.codeinglogs.data.domainrepositoryimp.bookmark

import android.util.Log
import com.codeinglogs.data.store.bookmark.bookmarktvshows.BookmarkTvShowsDataSore
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.repository.bookmark.BookmarkTvShowsRepositoryDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class BookmarkTvShowsRepositoryDomainImp @Inject constructor (private val bookmarkTvShowsDataSore : BookmarkTvShowsDataSore) :
    BookmarkTvShowsRepositoryDomain {

    override fun getBookmarkTvShows(id: Long) = flow {
        emit(State.loading())
        val check:Boolean
        check=bookmarkTvShowsDataSore.getLocalDataSource().isBookmarkTvShowsExist(id)
        Log.i("n4hkej", "getBookmarkTvShows: ${check}")
        if(!check){
            bookmarkTvShowsDataSore.getLocalDataSource().insertBookmarkTvShows(id)
        }
        emit(State.Success(!check))
    }.catch {
        emit(State.failed(it.message?:""))
    }.flowOn(Dispatchers.IO)

}