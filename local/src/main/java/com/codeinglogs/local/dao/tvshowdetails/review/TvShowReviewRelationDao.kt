package com.codeinglogs.local.dao.tvshowdetails.review
import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.tvshowdetails.reviews.TvShowReviewRelation
import com.codeinglogs.local.entity.tvshowdetails.reviews.TvShowReviews

@Dao
interface TvShowReviewRelationDao {
    @Insert
    suspend fun insert(tvShowReviewRelation: TvShowReviewRelation)

    @Update
    suspend fun update(tvShowReviewRelation: TvShowReviewRelation)

    @Delete
    suspend fun delete(tvShowReviewRelation: TvShowReviewRelation)

    @Query("SELECT * FROM TvShowReviewRelation")
    fun loadAllTvShowReviewRelation() : LiveData<TvShowReviewRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowReviewRelation(vararg tvShowReviewRelation: TvShowReviewRelation)

    @Query("SELECT * FROM TvShowReviews INNER JOIN tvShowReviewRelation ON TvShowReviews.id == tvShowReviewRelation.tvShowReviewsId WHERE tvShowReviewRelation.tvShowId == (:tvShowId)")
    fun getTvShowReviewRelation(tvShowId : Int) : List<TvShowReviews>
}