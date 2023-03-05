package com.example.vkintership.data.api

import com.example.vkintership.data.model.GifModel
import com.example.vkintership.data.model.ResponseModel
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class Repository : ApiService {
    override fun getGifs(query: String): Single<ResponseModel> {
        if (query.isEmpty()) {
            return Rx2AndroidNetworking.get("https://api.giphy.com/v1/gifs/trending")
                .addQueryParameter("api_key", "iNhpf2tmNBP1apC45cv6k0JVyuspf3AG")
                .build()
                .getObjectSingle(ResponseModel::class.java)
        } else {
            return Rx2AndroidNetworking.get("https://api.giphy.com/v1/gifs/search")
                .addQueryParameter("api_key", "iNhpf2tmNBP1apC45cv6k0JVyuspf3AG")
                .addQueryParameter("q", query)
                .build()
                .getObjectSingle(ResponseModel::class.java)
        }
    }
}