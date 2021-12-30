package com.codeinglogs.presentation.model.person.persondetails

import com.codeinglogs.presentation.model.person.persondetails.info.PersonInfoResponse
import com.codeinglogs.presentation.model.person.persondetails.externalids.PersonExternalIdsResponse
import com.codeinglogs.presentation.model.person.persondetails.externalids.toPresentationPersonExternalIdsResponse
import com.codeinglogs.presentation.model.person.persondetails.images.PersonImagesResponse
import com.codeinglogs.presentation.model.person.persondetails.images.toPresentationPersonImagesResponse
import com.codeinglogs.presentation.model.person.persondetails.info.toPresentationPersonInfoResponse
import com.codeinglogs.presentation.model.person.persondetails.moviecredits.PersonMovieCreditsResponse
import com.codeinglogs.presentation.model.person.persondetails.moviecredits.toPresentationPersonMovieCreditsResponse
import com.codeinglogs.presentation.model.person.persondetails.taggedimages.PersonTaggedImagesResponse
import com.codeinglogs.presentation.model.person.persondetails.taggedimages.toPresentationPersonTaggedImagesResponse
import com.codeinglogs.presentation.model.person.persondetails.tvcredits.PersonTvCreditsResponse
import com.codeinglogs.presentation.model.person.persondetails.tvcredits.toPresentationPersonTvCreditsResponse

import com.codeinglogs.domain.model.person.persondetails.PersonDetailsDisplay as DomainPersonDetailsDisplay

data class PersonDetailsDisplay(
    val personExternalIdsResponse: PersonExternalIdsResponse,
    val personImagesResponse: PersonImagesResponse,
    val personInfoResponse: PersonInfoResponse,
    val personMovieCreditsResponse: PersonMovieCreditsResponse,
    val personTaggedImagesResponse: PersonTaggedImagesResponse,
    val personTvCreditsResponse: PersonTvCreditsResponse
)

fun DomainPersonDetailsDisplay.toPresentationPersonDetailsDisplay()=PersonDetailsDisplay(

        personExternalIdsResponse = personExternalIdsResponse.toPresentationPersonExternalIdsResponse(),
        personImagesResponse = personImagesResponse.toPresentationPersonImagesResponse(),
        personInfoResponse = personInfoResponse.toPresentationPersonInfoResponse(),
        personMovieCreditsResponse = personMovieCreditsResponse.toPresentationPersonMovieCreditsResponse(),
        personTaggedImagesResponse = personTaggedImagesResponse.toPresentationPersonTaggedImagesResponse(),
        personTvCreditsResponse = personTvCreditsResponse.toPresentationPersonTvCreditsResponse()
)