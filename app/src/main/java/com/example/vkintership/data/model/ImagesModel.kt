package com.example.vkintership.data.model

import com.google.gson.annotations.SerializedName

data class ImagesModel(
    @SerializedName("fixed_height")
    var fixedHeight: FixedHeightModel? = null
)
