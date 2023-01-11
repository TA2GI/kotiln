package com.ta2gi.note.room

import androidx.room.*

@Dao
interface NoteDao {
    // 노트 가져오기
    @Query("SELECT * FROM NoteTable")
    fun getNote() : MutableList<NoteEntity>

    // 노트 추가
    @Insert
    fun insertNote(note : NoteEntity)

    // 노트 수정
    @Update
    fun updateNote(note : NoteEntity)

    // 노트 삭제
    @Delete
    fun deleteNote(note : NoteEntity)
}