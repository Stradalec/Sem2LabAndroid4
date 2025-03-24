package com.example.sem2labandroid4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDAO: NoteDAO) {
    suspend fun addDefaultNote() = withContext(Dispatchers.IO) {
        val defaultNote = Note(id = 0, title = "Спасательный круг", noteBody = "Без меня всё развалится")
        noteDAO.insertAll(defaultNote)
    }
    suspend fun getAllNotes() : List<Note> = withContext(Dispatchers.IO) {
         noteDAO.getAll()
    }

    suspend fun insetNote(note: Note) = withContext(Dispatchers.IO) {
        noteDAO.insertAll(note)
    }

    suspend fun deleteNote(note: Note) = withContext(Dispatchers.IO) {
        noteDAO.delete(note)
    }
}