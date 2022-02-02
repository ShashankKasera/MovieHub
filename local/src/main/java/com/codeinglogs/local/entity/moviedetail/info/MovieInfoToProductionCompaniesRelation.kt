package com.codeinglogs.local.entity.moviedetail.info

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.movies.moviedetail.info.MovieProductionCompanies as DataMovieProductionCompanies

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = MovieProductionCompanies::class,
            parentColumns = ["id"],
            childColumns = ["movieProductionCompaniesId"],
            onDelete = ForeignKey.CASCADE
        ),ForeignKey(
            entity = MovieInfoResponse::class,
            parentColumns = ["id"],
            childColumns = ["movieId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class MovieInfoToProductionCompaniesRelation(
    @PrimaryKey(autoGenerate = false)
    val id :String,
    val movieProductionCompaniesId : String,
    val movieId : String
)

fun DataMovieProductionCompanies.toLocalMovieInfoToProductionCompaniesRelation(movieId : String) = MovieInfoToProductionCompaniesRelation(
    getId(movieId,id.toString()), movieProductionCompaniesId = id.toString(),movieId=movieId)

fun List<DataMovieProductionCompanies>.toLocalMovieInfoToProductionCompaniesRelationList(movieId : String) : List<MovieInfoToProductionCompaniesRelation>{
    val list = mutableListOf<MovieInfoToProductionCompaniesRelation>()
    this.forEach { list.add(it.toLocalMovieInfoToProductionCompaniesRelation(movieId)) }
    return list
}