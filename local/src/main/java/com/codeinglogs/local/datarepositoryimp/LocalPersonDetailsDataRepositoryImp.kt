package com.codeinglogs.local.datarepositoryimp

import android.util.Log
import com.codeinglogs.data.model.person.persondetails.PersonDetailsDisplay
import com.codeinglogs.data.model.person.persondetails.images.PersonImagesResponse
import com.codeinglogs.data.model.person.persondetails.moviecredits.PersonMovieCreditsResponse
import com.codeinglogs.data.model.person.persondetails.taggedimages.PersonTaggedImagesResponse
import com.codeinglogs.data.model.person.persondetails.tvcredits.PersonTvCreditsResponse
import com.codeinglogs.data.repository.persondetails.LocalPersonDetailData
import com.codeinglogs.local.dao.persondetail.externalids.PersonExternalIdsResponseDao
import com.codeinglogs.local.dao.persondetail.image.PersonImagesDao
import com.codeinglogs.local.dao.persondetail.image.PersonImagesRelationDao
import com.codeinglogs.local.dao.persondetail.info.PersonInfoResponseDao
import com.codeinglogs.local.dao.persondetail.moviecredits.PersonMovieCastAndCrewDao
import com.codeinglogs.local.dao.persondetail.moviecredits.PersonMovieCastAndCrewRelationDao
import com.codeinglogs.local.dao.persondetail.taggedimages.PersonTaggedImagesDao
import com.codeinglogs.local.dao.persondetail.taggedimages.PersonTaggedImagesRelationDao
import com.codeinglogs.local.dao.persondetail.tvcredits.PersonTvCastAndCrewDao
import com.codeinglogs.local.dao.persondetail.tvcredits.PersonTvCastAndCrewRelationDao
import com.codeinglogs.local.entity.person.externalids.toDataPersonExternalIdsResponse
import com.codeinglogs.local.entity.person.externalids.toLocalPersonExternalIdsResponse
import com.codeinglogs.local.entity.person.image.toDataPersonImages
import com.codeinglogs.local.entity.person.image.toLocalPersonImagesList
import com.codeinglogs.local.entity.person.image.toLocalPersonImagesRelationList
import com.codeinglogs.local.entity.person.info.toDataPersonInfoResponse
import com.codeinglogs.local.entity.person.info.toLocalPersonInfoResponse
import com.codeinglogs.local.entity.person.moviecredits.toDataPersonMovieCastAndCrew
import com.codeinglogs.local.entity.person.moviecredits.toLocalPersonMovieCastAndCrewList
import com.codeinglogs.local.entity.person.moviecredits.toLocalPersonMovieCastAndCrewRelationList
import com.codeinglogs.local.entity.person.taggedimages.toDataPersonTaggedImages
import com.codeinglogs.local.entity.person.taggedimages.toLocalPersonTaggedImagesList
import com.codeinglogs.local.entity.person.taggedimages.toLocalPersonTaggedImagesRelationList
import com.codeinglogs.local.entity.person.tvcredits.toDataPersonTvCastAndCrew
import com.codeinglogs.local.entity.person.tvcredits.toLocalPersonTvCastAndCrewList
import com.codeinglogs.local.entity.person.tvcredits.toLocalPersonTvCastAndCrewRelationList
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocalPersonDetailsDataRepositoryImp @Inject constructor (
    private val personExternalIdsResponseDao: PersonExternalIdsResponseDao,
    private val personImagesDao: PersonImagesDao,
    private val personImagesRelationDao: PersonImagesRelationDao,
    private val personInfoResponseDao: PersonInfoResponseDao,
    private val personMovieCastAndCrewDao: PersonMovieCastAndCrewDao,
    private val personMovieCastAndCrewRelationDao: PersonMovieCastAndCrewRelationDao,
    private val personTaggedImagesDao: PersonTaggedImagesDao,
    private val personTaggedImagesRelationDao: PersonTaggedImagesRelationDao,
    private val personTvCastAndCrewDao: PersonTvCastAndCrewDao,
    private val personTvCastAndCrewRelationDao: PersonTvCastAndCrewRelationDao,

    ) : LocalPersonDetailData {
    override suspend fun getPersonDetail(personId: String): PersonDetailsDisplay {
        return coroutineScope{

            val personExternalIdsResponse=async {
                val personExternalIdsResponse=async { personExternalIdsResponseDao.getPersonExternalIdsResponse(personId.toInt()) }
                personExternalIdsResponse.await().toDataPersonExternalIdsResponse()
            }
            val personInfoResponse=async {
                val personInfoResponse=async { personInfoResponseDao.getPersonInfoResponse(personId.toInt()) }
                personInfoResponse.await().toDataPersonInfoResponse()
            }

            val personImagesResponse=async {
                val personImages=async { personImagesRelationDao.getPersonImagesRelation(personId.toInt()) }
                PersonImagesResponse(personId.toInt(),personImages.await().toDataPersonImages())
            }
            val personMovieCastAndCrewRelation=async {
                val personMovieCastAndCrew=async { personMovieCastAndCrewRelationDao.getPersonMovieCastAndCrewRelation(personId.toInt()) }
                PersonMovieCreditsResponse(personId.toInt(),personMovieCastAndCrew.await().toDataPersonMovieCastAndCrew())
            }
            val personTvCastAndCrewRelation=async {
                val personTvCastAndCrew=async { personTvCastAndCrewRelationDao.getPersonTvCastAndCrewRelation(personId.toInt()) }
                PersonTvCreditsResponse(personId.toInt(),personTvCastAndCrew.await().toDataPersonTvCastAndCrew())
            }
            val personTaggedImagesResponse=async {
                val personTaggedImagesResponse=async { personTaggedImagesRelationDao.getPersonTaggedImagesRelation(personId.toInt()) }
                PersonTaggedImagesResponse(personId.toInt(),personTaggedImagesResponse.await().toDataPersonTaggedImages())
            }

            PersonDetailsDisplay(
                personExternalIdsResponse.await(),
                personImagesResponse.await(),
                personInfoResponse.await(),
                personMovieCastAndCrewRelation.await(),
                personTaggedImagesResponse.await(),
                personTvCastAndCrewRelation.await()
            )
        }
    }

    override suspend fun isPersonDetailExist(personId: String): Boolean {
        Log.i("iuhuihi", "isPersonDetailExist: ${personInfoResponseDao.isPersonInfoIsExist(personId.toInt())})")
        return personInfoResponseDao.isPersonInfoIsExist(personId.toInt())
    }

    override suspend fun insertPersonDetail(personDetailsDisplay: PersonDetailsDisplay) {
        coroutineScope {
            launch {

                personExternalIdsResponseDao.insertAllPersonExternalIdsResponse(
                    personDetailsDisplay.personExternalIdsResponse.toLocalPersonExternalIdsResponse()
                )
                personInfoResponseDao.insertAllPersonInfoResponse(
                    personDetailsDisplay.personInfoResponse.toLocalPersonInfoResponse()
                )
                personImagesDao.insertAllPersonImages(
                    *personDetailsDisplay.personImagesResponse.profiles.toLocalPersonImagesList().toTypedArray()
                )
                personMovieCastAndCrewDao.insertAllPersonMovieCastAndCrew(
                    *personDetailsDisplay.personMovieCreditsResponse.credit.toLocalPersonMovieCastAndCrewList().toTypedArray()
                )
                personTvCastAndCrewDao.insertAllPersonTvCastAndCrew(
                    *personDetailsDisplay.personTvCreditsResponse.credit.toLocalPersonTvCastAndCrewList().toTypedArray()
                )
                personTaggedImagesDao.insertAllTvShowGenre(
                    *personDetailsDisplay.personTaggedImagesResponse.results.toLocalPersonTaggedImagesList().toTypedArray()
                )
            }
        }

        coroutineScope {
            launch {
                personImagesRelationDao.insertAllPersonImagesRelation(
                    *personDetailsDisplay.personImagesResponse.profiles.toLocalPersonImagesRelationList(
                        personDetailsDisplay.personInfoResponse.id.toString()
                    ).toTypedArray()
                )
                personMovieCastAndCrewRelationDao.insertAllPersonMovieCastAndCrewRelation(
                    *personDetailsDisplay.personMovieCreditsResponse.credit.toLocalPersonMovieCastAndCrewRelationList(
                        personDetailsDisplay.personInfoResponse.id.toString()
                    ).toTypedArray()
                )
                personTaggedImagesRelationDao.insertAllPersonTaggedImagesRelation(
                    *personDetailsDisplay.personTaggedImagesResponse.results.toLocalPersonTaggedImagesRelationList(
                        personDetailsDisplay.personInfoResponse.id.toString()
                    ).toTypedArray()
                )
                personTvCastAndCrewRelationDao.insertAllPersonTvCastAndCrewRelation(
                    *personDetailsDisplay.personTvCreditsResponse.credit.toLocalPersonTvCastAndCrewRelationList(
                        personDetailsDisplay.personInfoResponse.id.toString()
                    ).toTypedArray()
                )
            }
        }

    }
}