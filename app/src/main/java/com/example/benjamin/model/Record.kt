package com.example.benjamin.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "record")
data class Record(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    var virtueId : Int,
    val date: Long,
    val content: String
) : java.io.Serializable