package com.example.mediavault

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    private val _currentPage = MutableLiveData<String>("")
    val currentPage: LiveData<String> = _currentPage

    private val _previousPage = MutableLiveData<String>("")
    val previousPage: LiveData<String> = _previousPage

    fun savePage(newPage: String) {
        _previousPage.value = newPage
        _currentPage.value = _currentPage.value
    }
}