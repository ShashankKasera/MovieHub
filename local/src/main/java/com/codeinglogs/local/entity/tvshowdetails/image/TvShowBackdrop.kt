package com.codeinglogs.local.entity.tvshowdetails.image
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codeinglogs.data.model.tvshow.tvshowdetails.image.TvShowBackdrop as DataTvShowBackdrop
@Entity
data class TvShowBackdrop(
    @PrimaryKey()
    val file_path: String,
    val vote_count: Int,
)

fun TvShowBackdrop.toDataTvShowBackdrop() = DataTvShowBackdrop(
        file_path = file_path,
        vote_count = vote_count
    )

fun List<TvShowBackdrop>.toDataTvShowBackdrop() : List<DataTvShowBackdrop>{
    val list = mutableListOf<DataTvShowBackdrop>()
    this.forEach { list.add(it.toDataTvShowBackdrop()) }
    return list
}

fun DataTvShowBackdrop.toLocalTvShowBackdrop() = TvShowBackdrop(
    file_path=file_path,
    vote_count=vote_count
)

fun List<DataTvShowBackdrop>.toLocalTvShowBackdropList() : List<TvShowBackdrop>{
    val list = mutableListOf<TvShowBackdrop>()
    this.forEach { list.add(it.toLocalTvShowBackdrop()) }
    return list
}
