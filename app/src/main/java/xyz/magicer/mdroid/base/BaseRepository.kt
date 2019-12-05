package xyz.magicer.mdroid.base

import retrofit2.Response
import xyz.magicer.core.utils.logE

abstract class BaseRepository {

    suspend fun <T : Any> getResult(call: suspend () -> Response<T>): Result<T> {
        return try {
//            val response = withContext(Dispatchers.IO) { call() }
            val response = call()
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            } else {
                error("\n${response.code()} ${response.message()} \n ${response.errorBody()?.string()} ")
            }
        } catch (e: Exception) {
            error("Network Failed : ${e.message}")
        }
    }

    private fun <T> error(msg: String): Result<T> {
        logE(msg)
        return Result.error(msg)
    }
}