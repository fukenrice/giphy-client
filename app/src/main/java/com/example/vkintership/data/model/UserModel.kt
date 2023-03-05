package com.example.vkintership.data.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("avatar_url")
    var avatarUrl: String? = null,

    @SerializedName("banner_url")
    var bannerUrl: String? = null,

    @SerializedName("profile_url")
    var profileUrl: String? = null,

    @SerializedName("username")
    var username: String? = null,

    @SerializedName("display_name")
    var displayName: String? = null,
)
