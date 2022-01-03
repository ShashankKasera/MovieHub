package com.codeinglogs.remote.datarepositoryimp

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.person.persondetails.PersonDetailsDisplay
import com.codeinglogs.data.repository.persondetails.RemotePersonDetailData
import com.codeinglogs.remote.model.person.persondetail.externalids.toDataPersonExternalIdsResponse
import com.codeinglogs.remote.model.person.persondetail.images.toDataPersonImagesResponse
import com.codeinglogs.remote.model.person.persondetail.info.toDataPersonInfoResponse
import com.codeinglogs.remote.model.person.persondetail.moviecredits.toDataPersonMovieCreditsResponse
import com.codeinglogs.remote.model.person.persondetail.taggedimages.toDataPersonTaggedImagesResponse
import com.codeinglogs.remote.model.person.persondetail.tvcredits.toDataPersonTvCreditsResponse
import com.codeinglogs.remote.request.PersonRequest
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemotePersonDetailsDataRepositoryImp  @Inject constructor(private val personRequest: PersonRequest):
    RemotePersonDetailData
{
    override fun getPersonDetail(id: String)= flow<State<PersonDetailsDisplay>> {

        emit(State.loading())
        val data = coroutineScope{

            val PersonExternalIds = async { personRequest.getPersonExternalIds(id) }
            val PersonImages = async { personRequest.getPersonImages(id) }
            val PersonInfo = async { personRequest.getPersonInfo(id) }
            val PersonMovieCredits = async { personRequest.getPersonMovieCredits(id) }
            val PersonTaggedImages = async { personRequest.getPersonTaggedImages(id) }
            val PersonTvCredits = async { personRequest.getPersonTvCredits(id) }


            PersonDetailsDisplay(
                PersonExternalIds.await().toDataPersonExternalIdsResponse(),
                PersonImages.await().toDataPersonImagesResponse(),
                PersonInfo.await().toDataPersonInfoResponse(),
                PersonMovieCredits.await().toDataPersonMovieCreditsResponse(),
                PersonTaggedImages.await().toDataPersonTaggedImagesResponse(),
                PersonTvCredits.await().toDataPersonTvCreditsResponse()
                )
        }
        emit(State.success(data))
    }.catch {
        emit(State.failed(it.message?:""))
    }

}