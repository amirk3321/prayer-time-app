package com.c4coding.prayertime.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.c4coding.prayertime.data.model.Entity.PRIMARY_KEY
import com.c4coding.prayertime.data.model.Entity.TimingSchedule
import com.c4coding.prayertime.data.model.Entity.Timings

@Dao
interface PrayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun unpsert(timing : Timings)

    @Query("SELECT * FROM time_Schdule WHERE primary_key = $PRIMARY_KEY")
    fun getSchduleTimes() : LiveData<TimingSchedule>
}