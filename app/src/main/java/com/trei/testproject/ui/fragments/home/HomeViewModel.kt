package com.trei.testproject.ui.fragments.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.trei.testproject.data.entities.ImageListItem
import com.trei.testproject.data.repository.mRepository
import com.trei.testproject.utils.Resource


class HomeViewModel @ViewModelInject constructor(
    private val repository: mRepository
) : ViewModel() {
    val albums = repository.getAllAlbums()

    private val _id = MutableLiveData<Int>()

    private val _character = _id.switchMap { id ->
        repository.getImages(id)
    }
    val images = _character


    fun start(id: Int) {
        _id.value = id
    }

}
