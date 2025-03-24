package com.example.sem2labandroid4

import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDAO: NoteDAO) {
    suspend fun getAllNotes() : List<Note> {
        return  noteDAO.getAll()
    }

    suspend fun insetNote(note: Note) {
        noteDAO.insertAll(note)
    }

    suspend fun deleteNote(note: Note){
        noteDAO.delete(note)
    }
}