package com.codeinglogs.presentation.model


sealed class State<T> {
    class Loading<T>(val data: T? = null) : State<T>()
    data class Success<T>(val data: T) : State<T>()
    data class Failed<T>(val message: String) : State<T>()

    companion object {
        fun <T> loading(data: T? = null) = Loading<T>()
        fun <T> success(data: T) = Success(data)
        fun <T> failed(message: String) = Failed<T>(message)
    }
}

