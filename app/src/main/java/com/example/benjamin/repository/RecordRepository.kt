package com.example.benjamin.repository

import com.example.benjamin.model.Record

interface RecordRepository {
    suspend fun addRecord(record: Record)
}