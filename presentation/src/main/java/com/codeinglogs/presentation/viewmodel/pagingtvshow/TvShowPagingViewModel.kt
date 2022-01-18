package com.codeinglogs.presentation.viewmodel.pagingtvshow

import androidx.lifecycle.*
import androidx.paging.cachedIn
import androidx.paging.map
import com.codeinglogs.domain.usecase.GetTvShowPaging
import com.codeinglogs.presentation.model.tvshow.tvshowenum.TvShowType
import com.codeinglogs.presentation.model.tvshow.tvshowenum.toDomainTvShowType
import com.codeinglogs.presentation.model.tvshow.tvshowslist.toPresentationTvShow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class TvShowPagingViewModel @Inject constructor(
    private val getTvShowPaging : GetTvShowPaging,
    ) : ViewModel() {

    fun getTvShowList(type : TvShowType)  = getTvShowPaging(
        type.toDomainTvShowType()
    ).map {
        it.map {
            it.toPresentationTvShow()
        }
    }.cachedIn(viewModelScope).asLiveData()




}