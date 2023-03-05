package com.example.vkintership.data.api

import com.example.vkintership.data.model.GifModel
import com.example.vkintership.data.model.ResponseModel
import io.reactivex.Single

interface ApiService {
    fun getGifs(query: String): Single<ResponseModel>
}