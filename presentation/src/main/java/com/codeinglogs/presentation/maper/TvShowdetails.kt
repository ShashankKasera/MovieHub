package com.codeinglogs.presentation.maper

import com.codeinglogs.domain.model.State as Domain
import com.codeinglogs.presentation.model.State
import com.codeinglogs.domain.model.tvshow.tvshowdetails.TvShowDetailsDisplay
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.toPresentationTvShowDetails

fun Domain<TvShowDetailsDisplay>.toPresentationState()=
    when(this){
        is Domain.Loading->State.loading((this.data)?.toPresentationTvShowDetails())
        is Domain.Failed->State.Failed((this.message))
        is Domain.Success->State.Success(this.data.toPresentationTvShowDetails())
    }