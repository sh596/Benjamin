package com.example.benjamin.repository

import com.example.benjamin.model.Record
import com.example.benjamin.room.MainDatabase
import com.example.benjamin.room.RecordDao
import javax.inject.Inject

class VirtueSeeMoreRepositoryImpl (private val mainDao: RecordDao) : VirtueSeeMoreRepository {
    override suspend fun getRecordListById(id: Int): List<Record> {
        return mainDao.findRecordById(id)
    }
}