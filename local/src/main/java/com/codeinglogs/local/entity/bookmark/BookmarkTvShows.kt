package com.codeinglogs.local.entity.bookmark

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.TvShows

import com.codeinglogs.data.model.tvshow.tvshowlist.TvShow as DataTvShow
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = TvShows::class,
            parentColumns = ["id"],
            childColumns = ["tvShowId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class BookmarkTvShows(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val tvShowId : Long
)

fun DataTvShow.toLocalBookmarkTvShows() = BookmarkTvShows(tvShowId = id)

fun List<DataTvShow>.toLocalBookmarkTvShowsList() : List<BookmarkTvShows>{
    val list = mutableListOf<BookmarkTvShows>()
    this.forEach { list.add(it.toLocalBookmarkTvShows()) }
    return list
}
