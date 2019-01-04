package com.c4coding.prayertime.data.model

import com.google.gson.annotations.SerializedName

data class Gregorian(
    @SerializedName("date")
    val date: String,
    @SerializedName("day")
    val day: String,
    @SerializedName("designation")
    val designation: Designation,
    @SerializedName("format")
    val format: String,
    @SerializedName("month")
    val month: MonthX,
    @SerializedName("weekday")
    val weekday: WeekdayX,
    @SerializedName("year")
    val year: String
)