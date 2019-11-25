package xyz.magicer.mdroid.base


sealed class ResultWrapper<out T : Any> {

    data class Success<out T : Any>(val value: T) : ResultWrapper<T>()
    data class Error(val exception: Exception) : ResultWrapper<Nothing>()
    object NetworkError: ResultWrapper<Nothing>()

}

