package com.c4coding.prayertime.data.model

import com.google.gson.annotations.SerializedName

data class Method(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("params")
    val params: Params
)