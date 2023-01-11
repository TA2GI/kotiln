package com.ta2gi.note.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// tableName은 테이블명이며 안쓴다면 클래스명이 테이블명이 됨
@Entity(tableName = "NoteTable")
data class NoteEntity(
    // 고유 키 값, autoGenerate는 자동으로 증가시킴
    @PrimaryKey(autoGenerate = true)
    val uid : Int?,
    // ColumnInfo은 컬럼명을 변수명 그대로 사용함, 따로 이름을 붙일수도 있음
    @ColumnInfo
    val note : String,
    @ColumnInfo
    val date : String,
    @ColumnInfo
    val color : String
)
