package com.codeinglogs.local.dao.bookmark
import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Movies
import com.codeinglogs.local.entity.bookmark.BookmarkMovies

@Dao
interface BookmarkMoviesDao {

    @Insert
    suspend fun insert(movies: BookmarkMovies)

    @Update
    suspend fun update(movies: BookmarkMovies)

    @Delete
    suspend fun delete(movies: BookmarkMovies)

    @Query("SELECT * FROM BookmarkMovies")
    fun loadAllBookmarkMovies() : LiveData<BookmarkMovies>

    @Insert
    fun insertAllBookmarkMovies(vararg movies: BookmarkMovies)

    @Query("SELECT * FROM Movies INNER JOIN BookmarkMovies ON Movies.id == BookmarkMovies.movieId")
    fun getAllPopularMovies() : List<Movies>
}