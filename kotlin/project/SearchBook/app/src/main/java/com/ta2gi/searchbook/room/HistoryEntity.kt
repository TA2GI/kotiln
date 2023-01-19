package com.ta2gi.searchbook.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HistoryTable")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val bookUid : Int?,
    @ColumnInfo
    val searchWord : String
)
