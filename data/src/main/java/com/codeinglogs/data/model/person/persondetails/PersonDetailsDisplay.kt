package com.codeinglogs.data.model.person.persondetails

import com.codeinglogs.data.model.person.persondetails.info.PersonInfoResponse
import com.codeinglogs.data.model.person.persondetails.externalids.PersonExternalIdsResponse
import com.codeinglogs.data.model.person.persondetails.externalids.toDomainPersonExternalIdsResponse
import com.codeinglogs.data.model.person.persondetails.images.PersonImagesResponse
import com.codeinglogs.data.model.person.persondetails.images.toDomainPersonImagesResponse
import com.codeinglogs.data.model.person.persondetails.info.toDomainPersonInfoResponse
import com.codeinglogs.data.model.person.persondetails.moviecredits.PersonMovieCreditsResponse
import com.codeinglogs.data.model.person.persondetails.moviecredits.toDomainPersonMovieCreditsResponse
import com.codeinglogs.data.model.person.persondetails.taggedimages.PersonTaggedImagesResponse
import com.codeinglogs.data.model.person.persondetails.taggedimages.toDomainPersonTaggedImagesResponse
import com.codeinglogs.data.model.person.persondetails.tvcredits.PersonTvCreditsResponse
import com.codeinglogs.data.model.person.persondetails.tvcredits.toDomainPersonTvCreditsResponse

import com.codeinglogs.domain.model.person.persondetails.PersonDetailsDisplay as DomainPersonDetailsDisplay

data class PersonDetailsDisplay(
    val personExternalIdsResponse: PersonExternalIdsResponse,
    val personImagesResponse: PersonImagesResponse,
    val personInfoResponse: PersonInfoResponse,
    val personMovieCreditsResponse: PersonMovieCreditsResponse,
    val personTaggedImagesResponse: PersonTaggedImagesResponse,
    val personTvCreditsResponse: PersonTvCreditsResponse
)

fun PersonDetailsDisplay.toDomainPersonDetailsDisplay()=DomainPersonDetailsDisplay(

    personExternalIdsResponse =personExternalIdsResponse.toDomainPersonExternalIdsResponse(),
    personImagesResponse =personImagesResponse.toDomainPersonImagesResponse(),
    personInfoResponse =personInfoResponse.toDomainPersonInfoResponse(),
    personMovieCreditsResponse =personMovieCreditsResponse.toDomainPersonMovieCreditsResponse(),
    personTaggedImagesResponse =personTaggedImagesResponse.toDomainPersonTaggedImagesResponse(),
    personTvCreditsResponse =personTvCreditsResponse.toDomainPersonTvCreditsResponse()
)