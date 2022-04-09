package com.codeinglogs.local.entity.tvshowdetails.info
import androidx.room.Entity
import androidx.room.PrimaryKey
import  com.codeinglogs.data.model.tvshow.tvshowdetails.info.TvShowInfoResponse as DataTvShowInfoResponse

@Entity
data class TvShowInfoResponse(
    @PrimaryKey
    val id: Int,
    val backdrop_path: String,
    val first_air_date: String,
    val name: String,
    val number_of_episodes: Int,
    val number_of_seasons: Int,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val poster_path: String,
    val status: String,
    val tagline: String,
    val type: String,
    val vote_average: Double,
)


fun TvShowInfoResponse.toDataTvShowInfo(production_companies: List<TvShowProductionCompany>,
                                        genres: List<TvShowGenre>,
                                        seasons:List<TvShowSeason>) =
    DataTvShowInfoResponse(
        backdrop_path =backdrop_path,
        first_air_date =first_air_date,
        id=id,
        name =name,
        number_of_episodes=number_of_episodes,
        number_of_seasons=number_of_seasons,
        original_language =original_language,
        original_name =original_name,
        overview =overview,
        poster_path =poster_path,
        status =status,
        vote_average=vote_average,
        tagline =tagline,
        type =type,
        production_companies=production_companies.toDataTvShowProductionCompany(),
        genres=genres.toDataTvShowGenre(),
        seasons=seasons.toDataTvShowSeason(),
    )

fun DataTvShowInfoResponse.toLocalTvShowInfo() = TvShowInfoResponse(
    backdrop_path =backdrop_path,
    first_air_date =first_air_date,
    id=id,
    name =name,
    number_of_episodes=number_of_episodes,
    number_of_seasons=number_of_seasons,
    original_language =original_language,
    original_name =original_name,
    overview =overview,
    poster_path =poster_path,
    status =status,
    vote_average=vote_average,
    tagline =tagline,
    type =type,
)