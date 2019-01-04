package com.c4coding.prayertime.data.model

import com.c4coding.prayertime.data.model.Entity.Timings
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("date")
    val date: Date,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("timings")
    val timings: Timings
)