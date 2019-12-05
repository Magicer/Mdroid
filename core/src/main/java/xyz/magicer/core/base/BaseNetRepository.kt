package xyz.magicer.core.base

import retrofit2.Response
import xyz.magicer.core.bean.Error
import xyz.magicer.core.bean.NetResult
import xyz.magicer.core.bean.Success
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