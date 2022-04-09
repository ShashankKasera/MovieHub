package com.codeinglogs.local.entity.tvshowdetails.image
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codeinglogs.data.model.tvshow.tvshowdetails.image.TvShowPoster as DataTvShowPoster

@Entity
data class TvShowPoster (
    @PrimaryKey()
    val file_path: String,
    val vote_count: Int,
)

fun TvShowPoster.toDataTvShowPoster() = DataTvShowPoster(
        file_path = file_path,
        vote_count = vote_count
    )

fun List<TvShowPoster>.toDataTvShowPoster() : List<DataTvShowPoster>{
    val list = mutableListOf<DataTvShowPoster>()
    this.forEach { list.add(it.toDataTvShowPoster()) }
    return list
}

fun DataTvShowPoster.toLocalTvShowPoster() = TvShowPoster(
    file_path=file_path,
    vote_count=vote_count
)

fun List<DataTvShowPoster>.toLocalTvShowPosterList() : List<TvShowPoster>{
    val list = mutableListOf<TvShowPoster>()
    this.forEach { list.add(it.toLocalTvShowPoster()) }
    return list
}