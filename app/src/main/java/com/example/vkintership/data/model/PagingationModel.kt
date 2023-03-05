package com.example.vkintership.data.model

import com.google.gson.annotations.SerializedName

data class PaginationModel(
    @SerializedName("offset")
    var offset: Int? = null,

    @SerializedName("total_count")
    var totalCount: Int? = null,

    @SerializedName("count")
    var count: Int? = null,
)
