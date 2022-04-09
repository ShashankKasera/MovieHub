package com.codeinglogs.local.dao.tvshowdetails.review
import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.tvshowdetails.reviews.TvShowReviews

@Dao
interface TvShowReviewsDao {
    @Insert
    suspend fun insert(tvShowReviews: TvShowReviews)

    @Update
    suspend fun update(tvShowReviews: TvShowReviews)

    @Delete
    suspend fun delete(tvShowReviews: TvShowReviews)

    @Query("SELECT * FROM TvShowReviews")
    fun loadAllTvShowReviews() : LiveData<TvShowReviews>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowReviews(vararg tvShowReviews: TvShowReviews)
}