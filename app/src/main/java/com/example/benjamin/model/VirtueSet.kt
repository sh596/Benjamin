package com.example.benjamin.model

data class VirtueSet(
    val title: String,
    val mainVirtueId: Int,
    val virtue: List<Virtue>
): java.io.Serializable


data class Virtue(
    val id: Int,
    val virtue: String,
    val description: String
):java.io.Serializable

