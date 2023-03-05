package com.example.vkintership.data.model

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("data")
    var data: List<GifModel>? = null,

    @SerializedName("pagination")
    var pagination: PaginationModel? = null,

    @SerializedName("meta")
    var tema: MetaModel? = null,

)
