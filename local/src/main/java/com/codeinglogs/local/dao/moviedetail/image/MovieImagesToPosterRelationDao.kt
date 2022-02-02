package com.codeinglogs.local.dao.moviedetail.image

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.moviedetail.image.MovieBackdrop
import com.codeinglogs.local.entity.moviedetail.image.MovieImagesToBackdropRelation
import com.codeinglogs.local.entity.moviedetail.image.MovieImagesToMoviePosterRelation
import com.codeinglogs.local.entity.moviedetail.image.MoviePoster

@Dao
interface MovieImagesToPosterRelationDao {

    @Insert
    suspend fun insert(movieImagesToMoviePosterRelation: MovieImagesToMoviePosterRelation)

    @Update
    suspend fun update(movieImagesToMoviePosterRelation: MovieImagesToMoviePosterRelation)

    @Delete
    suspend fun delete(movieImagesToMoviePosterRelation: MovieImagesToMoviePosterRelation)

    @Query("SELECT * FROM MovieImagesToMoviePosterRelation")
    fun loadAllMovieImagesToMoviePosterRelation() : LiveData<MovieImagesToMoviePosterRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovieImagesToMoviePosterRelation(vararg movieImagesToMoviePosterRelation: MovieImagesToMoviePosterRelation)

    @Query("SELECT * FROM MoviePoster INNER JOIN movieImagesToMoviePosterRelation ON MoviePoster.file_path == movieImagesToMoviePosterRelation.moviePosterFilePath WHERE movieImagesToMoviePosterRelation.movieId == (:movieId)")
    fun getMovieImagesToMoviePosterRelation(movieId : Int) : List<MoviePoster>
}