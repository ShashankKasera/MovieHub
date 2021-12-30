package com.codeinglogs.domain.model.person.persondetails

import com.codeinglogs.domain.model.person.persondetails.info.PersonInfoResponse
import com.codeinglogs.domain.model.person.persondetails.externalids.PersonExternalIdsResponse
import com.codeinglogs.domain.model.person.persondetails.images.PersonImagesResponse
import com.codeinglogs.domain.model.person.persondetails.moviecredits.PersonMovieCreditsResponse
import com.codeinglogs.domain.model.person.persondetails.taggedimages.PersonTaggedImagesResponse
import com.codeinglogs.domain.model.person.persondetails.tvcredits.PersonTvCreditsResponse

data class PersonDetailsDisplay(
    val personExternalIdsResponse: PersonExternalIdsResponse,
    val personImagesResponse: PersonImagesResponse,
    val personInfoResponse: PersonInfoResponse,
    val personMovieCreditsResponse: PersonMovieCreditsResponse,
    val personTaggedImagesResponse: PersonTaggedImagesResponse,
    val personTvCreditsResponse: PersonTvCreditsResponse
) {
}