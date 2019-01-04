package com.c4coding.prayertime.data.model.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
const val PRIMARY_KEY=0
@Entity(tableName = "time_Schdule")
data class Timings(
    @SerializedName("Asr")
    val asr: String,
    @SerializedName("Dhuhr")
    val dhuhr: String,
    @SerializedName("Fajr")
    val fajr: String,
    @SerializedName("Imsak")
    val imsak: String,
    @SerializedName("Isha")
    val isha: String,
    @SerializedName("Maghrib")
    val maghrib: String,
    @SerializedName("Midnight")
    val midnight: String,
    @SerializedName("Sunrise")
    val sunrise: String,
    @SerializedName("Sunset")
    val sunset: String
){
    @PrimaryKey(autoGenerate = false)
    var primary_key : Int= PRIMARY_KEY
}