package com.codeinglogs.local.entity.tvshowdetails.info

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codeinglogs.data.model.tvshow.tvshowdetails.info.TvShowGenre as DataTvShowGenre

@Entity
data class TvShowGenre(
    @PrimaryKey
    val id: Int,
    val name: String,
)
fun TvShowGenre.toDataTvShowGener() =DataTvShowGenre (
        id = id,
        name = name
)

fun List<TvShowGenre>.toDataTvShowGenre() : List<DataTvShowGenre>{
    val list = mutableListOf<DataTvShowGenre>()
    this.forEach { list.add(it.toDataTvShowGener()) }
    return list
}

fun DataTvShowGenre.toLocalTvShowGenre() = TvShowGenre(
    id = id,
    name = name
)

fun List<DataTvShowGenre>.toLocalTvShowGenre() : List<TvShowGenre>{
    val list = mutableListOf<TvShowGenre>()
    this.forEach { list.add(it.toLocalTvShowGenre()) }
    return list
}