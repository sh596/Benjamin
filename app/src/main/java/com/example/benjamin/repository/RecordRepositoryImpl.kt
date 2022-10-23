package com.example.benjamin.repository

import com.example.benjamin.model.Record
import com.example.benjamin.room.MainDatabase
import com.example.benjamin.room.RecordDao
import javax.inject.Inject

class RecordRepositoryImpl (private val mainDao: RecordDao) : RecordRepository {
    override suspend fun addRecord(record: Record) {
        mainDao.insertAll(record)
    }
}