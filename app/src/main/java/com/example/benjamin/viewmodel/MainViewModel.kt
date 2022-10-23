package com.example.benjamin.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.benjamin.model.Virtue
import com.example.benjamin.model.VirtueSet
import com.example.benjamin.utils.Constans
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    private val _virtue = MutableLiveData<VirtueSet>()

    val virtue: LiveData<VirtueSet>
        get() = _virtue

    val virtueList = ObservableArrayList<Virtue>()

    fun getData(){

        _virtue.value = Constans.getDefaultVirtueData()

        virtueList.addAll(this.virtue.value!!.virtue)
    }

/*
    fun findVirtueById(id: Int) {
        viewModelScope.launch {
            _virtue.postValue(repository.findVirtueById(id))
        }
    }

    fun initVirtue() {
        viewModelScope.launch {
            repository.insertVirtue(Constants.getInitialVirtueData())
            findVirtueById(0)
        }
    }*/
}