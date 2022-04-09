package com.codeinglogs.local.dao.moviedetail.info

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.moviedetail.info.MovieInfoResponse
@Dao
interface MovieInfoResponseDao {

    @Insert
    suspend fun insert(movieInfoResponse: MovieInfoResponse)

    @Update
    suspend fun update(movieInfoResponse: MovieInfoResponse)

    @Delete
    suspend fun delete(movieInfoResponse: MovieInfoResponse)

    @Query("SELECT * FROM MovieInfoResponse")
    fun loadAllMovieInfoResponse() : LiveData<MovieInfoResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovieInfoResponse(vararg movieInfoResponse: MovieInfoResponse)

    @Query("SELECT * FROM MovieInfoResponse WHERE MovieInfoResponse.id == (:movieId)")
    fun getMovieInfoResponse(movieId : Int) : MovieInfoResponse

    @Query("SELECT EXISTS(SELECT * FROM MovieInfoResponse WHERE id = :movieId)")
    fun isMovieInfoIsExist(movieId : Int) : Boolean
}