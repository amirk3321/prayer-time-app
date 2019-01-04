package com.c4coding.prayertime.data.network.Response

import android.content.Context
import android.net.ConnectivityManager
import com.c4coding.prayertime.Internal.ExectionHandler
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionImpl(context :Context) : NetworkConnection {
    val appContext=context.applicationContext
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isOnline())
            throw ExectionHandler()

        return chain.proceed(chain.request())

    }
    private fun isOnline() : Boolean{
        val manager=appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo=manager.activeNetworkInfo
        return networkInfo!=null && networkInfo.isConnected
    }
}