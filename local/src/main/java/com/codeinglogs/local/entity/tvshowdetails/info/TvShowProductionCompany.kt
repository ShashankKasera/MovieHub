package com.codeinglogs.local.entity.tvshowdetails.info

import androidx.room.Entity
import androidx.room.PrimaryKey

import com.codeinglogs.data.model.tvshow.tvshowdetails.info.TvShowProductionCompany as DataTvShowProductionCompanies

@Entity
data class TvShowProductionCompany(
    @PrimaryKey
    val id:Int,
    val name: String
)

fun TvShowProductionCompany.toDataTvShowProductionCompany() =
   DataTvShowProductionCompanies(
        id = id,
        name = name
    )

fun List<TvShowProductionCompany>.toDataTvShowProductionCompany() : List<DataTvShowProductionCompanies>{
    val list = mutableListOf<DataTvShowProductionCompanies>()
    this.forEach { list.add(it.toDataTvShowProductionCompany()) }
    return list
}

fun DataTvShowProductionCompanies.toLocalTvShowProductionCompany() = TvShowProductionCompany(
    id=id,
    name = name
)

fun List<DataTvShowProductionCompanies>.toLocalTvShowProductionCompany() : List<TvShowProductionCompany>{
    val list = mutableListOf<TvShowProductionCompany>()
    this.forEach { list.add(it.toLocalTvShowProductionCompany()) }
    return list
}
