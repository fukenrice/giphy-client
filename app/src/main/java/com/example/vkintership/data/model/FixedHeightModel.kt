package com.example.vkintership.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class FixedHeightModel(
    @SerializedName("url")
    var url: String? = null
) : java.io.Serializable