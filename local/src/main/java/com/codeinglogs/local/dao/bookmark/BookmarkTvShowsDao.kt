package com.codeinglogs.local.dao.bookmark
import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.codeinglogs.local.entity.TvShows
import com.codeinglogs.local.entity.bookmark.BookmarkTvShows

@Dao
interface BookmarkTvShowsDao {

    @Insert
    suspend fun insert(tvShows: BookmarkTvShows)

    @Update
    suspend fun update(tvShows: BookmarkTvShows)

    @Delete
    suspend fun delete(tvShows: BookmarkTvShows)

    @Query("SELECT * FROM BookmarkTvShows")
    fun loadAllBookmarkTvShows() : LiveData<BookmarkTvShows>

    @Insert
    fun insertAllBookmarkTvShows(vararg tvShows: BookmarkTvShows)

    @Query("SELECT * FROM TvShows INNER JOIN BookmarkTvShows ON TvShows.id == BookmarkTvShows.tvShowId")
    fun getAllBookmarkTvShows() : List<TvShows>

    @Query("SELECT EXISTS(SELECT * FROM BookmarkTvShows WHERE tvShowId = :tvShowId)")
    fun isBookmarkTvShowsIsExist(tvShowId : Long) : Boolean
}