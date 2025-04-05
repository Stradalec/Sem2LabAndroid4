package com.example.sem2labandroid4.domain

import com.example.sem2labandroid4.domain.model.NoteModel


interface INoteRepository {
    suspend fun addDefaultNote()
    suspend fun getAllNotes(): List<NoteModel>
    suspend fun insetNote(note: NoteModel)
    suspend fun deleteNote(note: NoteModel)
}