package com.example.vkintership.data.model

import com.google.gson.annotations.SerializedName

data class MetaModel(
    @SerializedName("msg")
    var msg: String? = null,

    @SerializedName("status")
    var status: Int?  = null,

    @SerializedName("response_id")
    var responseId: String? = null,
)
