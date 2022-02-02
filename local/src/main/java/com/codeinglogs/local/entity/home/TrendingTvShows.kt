package com.codeinglogs.local.entity.home

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.TvShows
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShow as DataTvShow

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = TvShows::class,
            parentColumns = ["id"],
            childColumns = ["tvShowId"],
            onDelete = CASCADE
        )
    ]
)
data class TrendingTvShows(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val tvShowId : Long
)

fun DataTvShow.toLocalTrendingTvShows() = TrendingTvShows(tvShowId = id)

fun List<DataTvShow>.toLocalTrendingTvShowsList() : List<TrendingTvShows>{
    val list = mutableListOf<TrendingTvShows>()
    this.forEach { list.add(it.toLocalTrendingTvShows()) }
    return list
}



