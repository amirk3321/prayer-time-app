package com.c4coding.prayertime.data.model.Entity

import androidx.room.ColumnInfo


data class TimingSchedule(
    @ColumnInfo(name = "asr")
    val asr: String,
    @ColumnInfo(name = "dhuhr")
    val dhuhr: String,
    @ColumnInfo(name = "fajr")
    val fajr: String,
    @ColumnInfo(name = "imsak")
    val imsak: String,
    @ColumnInfo(name = "isha")
    val isha: String,
    @ColumnInfo(name = "maghrib")
    val maghrib: String,
    @ColumnInfo(name = "midnight")
    val midnight: String,
    @ColumnInfo(name = "sunrise")
    val sunrise: String,
    @ColumnInfo(name = "sunset")
    val sunset: String
) {
}