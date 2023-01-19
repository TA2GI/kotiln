package com.ta2gi.searchbook.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDao {
    // 찜 목록 가져오기
    @Query("SELECT * FROM HistoryTable")
    fun getHistory() : MutableList<HistoryEntity>

    // 찜 목록에 삽입
    @Insert
    fun insertHistory(book : HistoryEntity)

    // 찜 목록에서 제거
    @Delete
    fun deleteHistory(book : HistoryEntity)

    @Query("DELETE from HistoryTable")
    fun deleteAllHistory()

}