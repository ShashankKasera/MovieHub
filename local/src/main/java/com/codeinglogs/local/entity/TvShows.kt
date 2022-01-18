package com.codeinglogs.local.entity
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShow as DataTvShow

@Entity
data class TvShows(

    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val original_name: String,
    val first_air_date: String,
    val overview: String,
    val vote_average: Double,
    val poster_path: String,
)

fun TvShows.toDataTvShow()= DataTvShow(
    id=id,
    name=name,
    original_name=original_name,
    first_air_date=first_air_date,
    overview=overview,
    vote_average=vote_average,
    poster_path=poster_path,

)


fun List<TvShows>.toDataTvShowList() : List<DataTvShow>{
    val list = mutableListOf<DataTvShow>()
    this.forEach { list.add(it.toDataTvShow()) }
    return list
}

fun DataTvShow.toLocalTvShows() = TvShows(
    id=id,
    name=name,
    original_name=original_name,
    first_air_date=first_air_date,
    overview=overview,
    vote_average=vote_average,
    poster_path=poster_path,
)

fun List<DataTvShow>.toLocalTvShows():List<TvShows>{
    val list = mutableListOf<TvShows>()
    this.forEach { list.add(it.toLocalTvShows()) }
    return list
}
