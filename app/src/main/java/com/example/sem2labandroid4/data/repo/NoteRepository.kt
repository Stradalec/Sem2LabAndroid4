package com.example.sem2labandroid4.data.repo

import com.example.sem2labandroid4.data.local.Note
import com.example.sem2labandroid4.data.local.NoteDAO
import com.example.sem2labandroid4.domain.INoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDAO: NoteDAO) : INoteRepository {
    override suspend fun addDefaultNote(){
        val defaultNote =
            Note(id = 0, title = "Спасательный круг", noteBody = "Без меня всё развалится")
        noteDAO.insertAll(defaultNote)
    }

    override suspend fun getAllNotes(): List<Note> = withContext(Dispatchers.IO) {
        noteDAO.getAll()
    }

    override suspend fun insetNote(note: Note)  {
        noteDAO.insertAll(note)
    }

    override suspend fun deleteNote(note: Note) = withContext(Dispatchers.IO) {
        noteDAO.delete(note)
    }
}