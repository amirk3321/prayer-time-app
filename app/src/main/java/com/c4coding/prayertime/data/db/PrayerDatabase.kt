package com.c4coding.prayertime.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.c4coding.prayertime.data.model.Entity.Timings

@Database(
    entities =[Timings::class],
    version = 1
)
abstract class PrayerDatabase : RoomDatabase() {
    abstract fun prayerDao(): PrayerDao

    companion object {
        @Volatile private var instance: PrayerDatabase? = null
        private val look = Any()
        operator fun invoke(context: Context) =
            instance ?: synchronized(look) {
                instance ?: bindRoom(context).also {
                    instance=it
                }
            }
        private fun bindRoom(context: Context) =Room
            .databaseBuilder(context.applicationContext, PrayerDatabase::class.java, "database.db")
            .build()
    }
}