package com.example.benjamin.room

import androidx.room.*
import com.example.benjamin.model.Record

@Dao
interface RecordDao {
    @Update
    suspend fun update(record: Record)

    @Insert
    suspend fun insertAll(vararg record: Record)

    @Delete
    suspend fun delete(record: Record)

    @Query("SELECT * FROM record")
    suspend fun getAllData() : List<Record>

    @Query("Select * From record where virtueId = :id")
    suspend fun findRecordById(id: Int): List<Record>


}