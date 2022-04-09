package com.codeinglogs.local.entity.tvshowdetails.video
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codeinglogs.data.model.tvshow.tvshowdetails.video.TvShowsVideos as DataTvShowsVideos

@Entity
data class TvShowVideo (
    @PrimaryKey
    val id: String,
    val key: String,
    val name: String,
)


fun TvShowVideo.toDataTvShowVideo() =
   DataTvShowsVideos(
        id = id,
        key = key,
        name = name,
    )

fun List<TvShowVideo>.toDataTvShowVideo() : List<DataTvShowsVideos>{
    val list = mutableListOf<DataTvShowsVideos>()
    this.forEach { list.add(it.toDataTvShowVideo()) }
    return list
}

fun DataTvShowsVideos.toLocalTvShowVideo() = TvShowVideo(
    id =id,
    key =key,
    name =name,
)

fun List<DataTvShowsVideos>.toLocalTvShowVideo() : List<TvShowVideo>{
    val list = mutableListOf<TvShowVideo>()
    this.forEach { list.add(it.toLocalTvShowVideo()) }
    return list
}