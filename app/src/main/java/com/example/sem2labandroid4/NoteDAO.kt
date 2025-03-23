package com.example.sem2labandroid4

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDAO {
    @Insert
    fun insertAll(vararg: Note)

    @Delete
    fun  delete(note: Note)

    @Query("SELECT * FROM note")
    fun getAll(): List<Note>
}