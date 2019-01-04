package com.c4coding.prayertime.data.model

import com.google.gson.annotations.SerializedName

data class CurrentTimings(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: String
)