package com.example.vkintership.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ImagesModel(
    @SerializedName("fixed_height")
    var fixedHeight: FixedHeightModel? = null
) : java.io.Serializable
