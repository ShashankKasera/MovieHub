package com.codeinglogs.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
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
data class TopRatedTvShows(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val tvShowId : Long
)

fun DataTvShow.toLocalTopRatedTvShows() = TopRatedTvShows(tvShowId = id)

fun List<DataTvShow>.toLocalTopRatedTvShowsList() : List<TopRatedTvShows>{
    val list = mutableListOf<TopRatedTvShows>()
    this.forEach { list.add(it.toLocalTopRatedTvShows()) }
    return list
}



