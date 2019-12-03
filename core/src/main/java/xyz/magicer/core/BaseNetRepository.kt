package xyz.magicer.core

import retrofit2.Response
import java.io.IOException

abstract class BaseNetRepository {

    suspend fun <T : Any> getResult(call: suspend () -> Response<T>): NetResult<T> {
        return try {
            val response = call()
            if (response.isSuccessful && response.body() != null) {
                Success(response.body()!!)
            } else {
                Error(IOException(" code = ${response.code()}  message = ${response.message()} \n ${response.errorBody()}"))
            }
        } catch (e: Exception) {
            Error(e)
        }
    }

}