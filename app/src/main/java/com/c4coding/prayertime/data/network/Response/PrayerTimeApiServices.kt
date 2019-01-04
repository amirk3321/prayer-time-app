package com.c4coding.prayertime.data.network.Response

import com.c4coding.prayertime.data.model.CurrentTimings
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL="http://api.aladhan.com/v1/"
interface PrayerTimeApiServices {
    @GET("timingsByCity")
    fun getTiming(
        @Query("city") city :String,
        @Query("country") country : String) : Deferred<CurrentTimings>

    companion object {
        operator fun invoke(networkConnection: NetworkConnection) : PrayerTimeApiServices{
            val interceptor= Interceptor {
                chain ->

                val request=chain.request()
                    .newBuilder()
                    .build()
                return@Interceptor chain.proceed(request)
            }

            val okHttpClient=OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(networkConnection)
                .build()

                return Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(PrayerTimeApiServices::class.java)
        }
    }

}