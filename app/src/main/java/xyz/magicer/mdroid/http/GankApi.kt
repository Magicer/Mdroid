package xyz.magicer.mdroid.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import xyz.magicer.mdroid.base.TodayResult
import xyz.magicer.mdroid.utils.BASE_URL
import java.util.concurrent.TimeUnit


interface GankApi {

    @GET("today")
    suspend fun getToday():Response<TodayResult>


    companion object Factory {
        fun create(): GankApi {
            val retrofit = Retrofit.Builder()
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor())
                        .connectTimeout(3, TimeUnit.SECONDS)
                        .build()
                )
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(GankApi::class.java)
        }
    }


}