package com.c4coding.prayertime.data.network.Response

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.c4coding.prayertime.Internal.ExectionHandler
import com.c4coding.prayertime.data.model.Entity.Timings

class NetworkDataSourcempl(
    private val prayerTimeApiServices: PrayerTimeApiServices
) : NetworkDataSource {
    private val _listOfPrayers =MutableLiveData<Timings>()
    override val listOfPrayers: LiveData<Timings>
        get() = _listOfPrayers


    override suspend fun getCurrentTiming(city: String, country: String) {
        try {
                val response= prayerTimeApiServices.getTiming(city,country)
                    .await()
                _listOfPrayers.postValue(response.data.timings)


        }catch (e : ExectionHandler){
            Log.e("NetworkIOExecption"," Error :"+e.message.toString())
        }

    }




}