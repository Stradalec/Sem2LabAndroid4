package com.example.sem2labandroid4


import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
class  NoteDatabaseModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(@ApplicationContext context: Context) : NoteDatabase {
        return  Room.databaseBuilder(context,NoteDatabase::class.java, "note_database").build()
    }
    @Provides
    fun provideNoteDao(database: NoteDatabase) : NoteDAO {
        return database.noteDao()
    }

}

