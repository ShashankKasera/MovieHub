package com.codeinglogs.remote.model.moviedetail.similar
import com.codeinglogs.data.model.moviedetail.similar.MovieSimilar as dataMovieSimilar

data class MovieSimilar(
    val adult: Boolean?,
    val backdrop_path: String?,
    val genre_ids: List<Int>?,
    val id: Int?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int
)

fun MovieSimilar.todataMovieSimilar()=dataMovieSimilar(
    id=id?:0,
    original_title=original_title?:"",
    poster_path=poster_path?:"",
    title=title?:"",
    vote_average=vote_average?:0.0,

)