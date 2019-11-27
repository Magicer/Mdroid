package xyz.magicer.mdroid.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import xyz.magicer.mdroid.BuildConfig
import xyz.magicer.mdroid.model.bean.WanBanner
import xyz.magicer.mdroid.utils.BASE_URL_WANDROID
import java.util.concurrent.TimeUnit


interface WanApi {

    @GET("/banner/json")
    suspend fun banner(): Response<WanBanner>


    companion object Factory {
        fun create(url: String = BASE_URL_WANDROID): WanApi {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            val logging = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                logging.level = HttpLoggingInterceptor.Level.BODY
            } else {
                logging.level = HttpLoggingInterceptor.Level.BASIC
            }
            val retrofit = Retrofit.Builder()
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(httpLoggingInterceptor)
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