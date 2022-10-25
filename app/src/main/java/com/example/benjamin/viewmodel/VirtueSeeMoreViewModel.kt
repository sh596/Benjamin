package com.example.benjamin.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.benjamin.model.Record
import com.example.benjamin.repository.VirtueSeeMoreRepository
import com.example.benjamin.repository.VirtueSeeMoreRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VirtueSeeMoreViewModel @Inject constructor(private val repository: VirtueSeeMoreRepositoryImpl) :
    ViewModel() {

    private val _record = MutableLiveData<List<Record>>()

    val record: LiveData<List<Record>>
        get() = _record

    val recordList = ObservableArrayList<Record>()

    val deleteRecordFunction = { record: Record ->
        deleteRecord(record)
    }

    fun getRecordListById(id: Int) {
        viewModelScope.launch {
            val modelData = repository.getRecordListById(id)
            launch(Dispatchers.Main) {
                _record.value = modelData
                recordList.clear()
                record.value?.let { recordList.addAll(it) }
            }
        }
    }

    fun deleteRecord(record: Record) {
        viewModelScope.launch {
            repository.deleteRecord(record)
        }
    }
}