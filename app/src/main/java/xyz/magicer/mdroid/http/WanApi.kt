package xyz.magicer.mdroid.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import xyz.magicer.mdroid.model.bean.WanBanner
import xyz.magicer.mdroid.utils.BASE_URL_WANDROID
import java.util.concurrent.TimeUnit


interface WanApi {

    @GET("/banner/json")
    suspend fun banner(): Response<WanBanner>


    companion object Factory {
        fun create(url: String = BASE_URL_WANDROID): WanApi {
            val retrofit = Retrofit.Builder()
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor())
                        .connectTimeout(3, TimeUnit.SECONDS)
                        .build()
                )
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build()

            return retrofit.create(WanApi::class.java)
        }
    }


}