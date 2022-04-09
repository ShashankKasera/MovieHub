package com.codeinglogs.local.entity.tvshowdetails.credits
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.tvshowdetails.info.TvShowInfoResponse
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.person.personlist.Person as DataTvShowCast

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Persons::class,
            parentColumns = ["id"],
            childColumns = ["tvShowCastId"],
            onDelete = ForeignKey.CASCADE
        ), ForeignKey(
            entity = TvShowInfoResponse::class,
            parentColumns = ["id"],
            childColumns = ["tvShowId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TvShowCreditsToCastRelation(
    @PrimaryKey(autoGenerate = false)
    val id : String,// id_12123_31223
    val tvShowCastId : String, //12123
    val tvShowId : String, //31223
)

fun DataTvShowCast.toLocalTvShowCreditsToCastRelation(tvShowId : String,) = TvShowCreditsToCastRelation(
    getId(tvShowId,id.toString()),tvShowCastId = id.toString(),tvShowId=tvShowId)

fun List<DataTvShowCast>.toLocalTvShowCreditsToCastRelationList(tvShowId : String,) : List<TvShowCreditsToCastRelation>{
    val list = mutableListOf<TvShowCreditsToCastRelation>()
    this.forEach { list.add(it.toLocalTvShowCreditsToCastRelation(tvShowId)) }
    return list
}
