package com.c4coding.prayertime.data.model

import com.google.gson.annotations.SerializedName

data class Month(
    @SerializedName("ar")
    val ar: String,
    @SerializedName("en")
    val en: String,
    @SerializedName("number")
    val number: Int
)