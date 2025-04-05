package com.example.sem2labandroid4.data.local


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sem2labandroid4.data.local.Note
import com.example.sem2labandroid4.data.local.NoteDAO

@Database(entities = [Note::class], version = 2, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao() : NoteDAO

}