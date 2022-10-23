package com.example.benjamin.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.benjamin.model.Record
import com.example.benjamin.repository.RecordRepository
import com.example.benjamin.repository.RecordRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecordViewModel @Inject constructor(private val repository: RecordRepositoryImpl)  : ViewModel() {
    val content = MutableLiveData<String>()

    init {
        content.value = ""
    }

    fun addRecord(id : Int) {
        val now = System.currentTimeMillis()
        viewModelScope.launch {
            repository.addRecord(Record(virtueId = id, content = content.value.toString(), date = now))
            Log.d(TAG, "addRecord: $id ${content.value.toString()}")
        }
    }

}