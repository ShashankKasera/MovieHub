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
data class PopularTvShows(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val tvShowId : Long
)

fun DataTvShow.toLocalPopularTvShows() = PopularTvShows(tvShowId = id)

fun List<DataTvShow>.toLocalPopularTvShowsList() : List<PopularTvShows>{
    val list = mutableListOf<PopularTvShows>()
    this.forEach { list.add(it.toLocalPopularTvShows()) }
    return list
}



