package com.codeinglogs.local.entity.tvshowdetails.info

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codeinglogs.data.model.tvshow.tvshowdetails.info.TvShowSeason as DataTvShowSeason

@Entity
data class TvShowSeason(
    @PrimaryKey
    val id: Int,
    val air_date: String,
    val episode_count: Int,

    val name: String,
    val overview: String,
    val poster_path: String,
    val season_number: Int
)

fun TvShowSeason.toDataTvShowSeason() =
    DataTvShowSeason(
        id=id,
        name=name,
        overview = overview,
        season_number = season_number,
        episode_count = episode_count,
        air_date=air_date,
        poster_path=poster_path
    )

fun List<TvShowSeason>.toDataTvShowSeason() : List<DataTvShowSeason>{
    val list = mutableListOf<DataTvShowSeason>()
    this.forEach { list.add(it.toDataTvShowSeason()) }
    return list
}

fun DataTvShowSeason.toLocalTvShowSeason() = TvShowSeason(
    id=id,
    name=name,
    overview = overview,
    season_number = season_number,
    episode_count = episode_count,
    air_date=air_date,
    poster_path=poster_path
)

fun List<DataTvShowSeason>.toLocalTvShowSeason() : List<TvShowSeason>{
    val list = mutableListOf<TvShowSeason>()
    this.forEach { list.add(it.toLocalTvShowSeason()) }
    return list
}