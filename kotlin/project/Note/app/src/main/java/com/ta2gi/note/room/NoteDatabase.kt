package com.ta2gi.note.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDao

    // 데이터베이스를 딱 한번만 생성하겠다는 코드
    companion object {
        private var instance : NoteDatabase? = null

        @Synchronized
        fun getInstance(context: Context): NoteDatabase? {
            if (instance == null) {
                synchronized(NoteDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "note.db"
                    ).build()
                }
            }

            return instance
        }
    }
}