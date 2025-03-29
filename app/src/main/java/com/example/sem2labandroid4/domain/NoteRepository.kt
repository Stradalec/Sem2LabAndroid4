package com.example.sem2labandroid4.domain

import com.example.sem2labandroid4.data.local.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface INoteRepository {
    suspend fun addDefaultNote()
    suspend fun getAllNotes(): List<Note>
    suspend fun insetNote(note: Note)
    suspend fun deleteNote(note: Note)
}