package com.c4coding.prayertime.data.network.Response

import androidx.lifecycle.LiveData

import com.c4coding.prayertime.data.model.Entity.Timings

interface NetworkDataSource {
    val listOfPrayers : LiveData<Timings>

    suspend fun getCurrentTiming(city : String,country :String)
}