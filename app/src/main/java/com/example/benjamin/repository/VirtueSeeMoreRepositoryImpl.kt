package com.example.benjamin.repository

import com.example.benjamin.model.Record
import com.example.benjamin.room.RecordDao

class VirtueSeeMoreRepositoryImpl(private val recordDao: RecordDao) : VirtueSeeMoreRepository {
    override suspend fun getRecordListById(id: Int): List<Record> {
        return recordDao.findRecordById(id)
    }

    override suspend fun deleteRecord(record: Record) {
        recordDao.delete(record)
    }
}