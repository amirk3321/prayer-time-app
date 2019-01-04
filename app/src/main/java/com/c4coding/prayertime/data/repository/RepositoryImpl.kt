package com.c4coding.prayertime.data.repository

import androidx.lifecycle.LiveData
import com.c4coding.prayertime.data.db.PrayerDao
import com.c4coding.prayertime.data.model.Entity.TimingSchedule
import com.c4coding.prayertime.data.model.Entity.Timings
import com.c4coding.prayertime.data.network.Response.NetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RepositoryImpl(
    private val prayerDao: PrayerDao,
    private val networkDataSource: NetworkDataSource
) : Repository {
    override suspend fun getCurrentTime(): LiveData<TimingSchedule> {
        return withContext(Dispatchers.IO){
            onFetchCurrentPrayerTimings()
            return@withContext prayerDao.getSchduleTimes()
        }
    }
    init {
        networkDataSource.listOfPrayers.observeForever {
            insertRoomDataPresist(it)
        }
    }

    private fun insertRoomDataPresist(timings: Timings) {
        GlobalScope.launch(Dispatchers.IO) {
            prayerDao.unpsert(timings)
        }

    }
    private suspend fun onFetchCurrentPrayerTimings(){
        networkDataSource.getCurrentTiming("karachi","pakistan")
    }
}