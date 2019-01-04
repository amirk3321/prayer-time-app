package com.c4coding.prayertime.data.repository

import androidx.lifecycle.LiveData
import com.c4coding.prayertime.data.model.Entity.TimingSchedule
import com.c4coding.prayertime.data.model.Entity.Timings

interface Repository {
    suspend fun getCurrentTime() : LiveData<TimingSchedule>
}