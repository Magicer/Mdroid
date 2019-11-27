package xyz.magicer.mdroid.base

sealed class NetResult<out T>

data class Success<out T>(val data: T) : NetResult<T>()

data class Error(val exception: Exception) : NetResult<Nothing>()
