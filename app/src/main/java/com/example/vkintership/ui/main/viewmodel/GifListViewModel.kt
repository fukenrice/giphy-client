package com.example.vkintership.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vkintership.data.api.Repository
import com.example.vkintership.data.model.GifModel
import com.example.vkintership.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class GifListViewModel(private val repository: Repository) : ViewModel() {
    private val gifs = MutableLiveData<Resource<List<GifModel>>>()
    private var request: Disposable? = null

    init {
        fetchGifs("")
    }

    private fun fetchGifs(query: String) {
        gifs.postValue(Resource.loading(null))
        request = repository.getGifs(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({gifResponse ->
                gifs.postValue(Resource.success(gifResponse.data))
            }, { throwable ->
                gifs.postValue(Resource.error(throwable.message.toString(), null))
            })
    }

    public fun fetchByQuery(query: String) {
        fetchGifs(query)
    }

    public fun getGifs() : LiveData<Resource<List<GifModel>>> {
        return gifs
    }

    override fun onCleared() {
        super.onCleared()
        request?.dispose()
    }
}
