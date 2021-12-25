package com.codeinglogs.data.model

import com.codeinglogs.domain.model.State as DataState

sealed class State<T> {
    class Loading<T>(val data: T? = null) : State<T>()
    data class Success<T>(val data: T) : State<T>()
    data class Failed<T>(val message: String) : State<T>()

    companion object {
        fun <T> loading(data: T? = null) = Loading<T>(data)
        fun <T> success(data: T) = Success(data)
        fun <T> failed(message: String) = Failed<T>(message)
    }
}

