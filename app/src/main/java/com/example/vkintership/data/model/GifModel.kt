package com.example.vkintership.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class GifModel(
    @SerializedName("type")
    var type: String = "gif",

    @SerializedName("id")
    var id: String? = null,

    @SerializedName("slug")
    var slug: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("bitly_url")
    var bitlyUrl: String? = null,

    @SerializedName("embed_url")
    var embedUrl: String? = null,

    @SerializedName("username")
    var username: String? = null,

    @SerializedName("source")
    var source: String? = null,

    @SerializedName("rating")
    var rating: String? = null,

    @SerializedName("images")
    var images: ImagesModel? = null,

    @SerializedName("content_url")
    var content_url: String? = null,

    @SerializedName("user")
    var user: UserModel? = null,

    @SerializedName("source_tld")
    var sourceTld: String? = null,

    @SerializedName("source_post_url")
    var sourcePostUrl: String? = null,

    @SerializedName("update_datetime")
    var updateDateTime: String? = null,

    @SerializedName("create_datetime")
    var createDateTime: String? = null,

    @SerializedName("import_datetime")
    var importDateTime: String? = null,

    @SerializedName("trending_datetime")
    var trendingDateTime: String? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("alt_text")
    var altText: String? = null,
) : java.io.Serializable
