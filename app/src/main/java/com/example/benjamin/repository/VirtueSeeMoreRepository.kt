package com.example.benjamin.repository

import com.example.benjamin.model.Record

interface VirtueSeeMoreRepository {
    suspend fun getRecordListById(id: Int) : List<Record>
}