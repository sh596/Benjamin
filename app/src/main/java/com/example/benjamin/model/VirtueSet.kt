package com.example.benjamin.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

data class VirtueSet(
    val title: String,
    val mainVirtueIndex: Int,
    val virtue: List<Virtue>
): java.io.Serializable


data class Virtue(
    val id: Int,
    val virtue: String,
    val description: String
):java.io.Serializable

