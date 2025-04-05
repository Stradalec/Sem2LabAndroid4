package com.example.sem2labandroid4.data.repo

import com.example.sem2labandroid4.data.local.Note
import com.example.sem2labandroid4.data.local.NoteDAO
import com.example.sem2labandroid4.data.toDomain
import com.example.sem2labandroid4.data.toEntity
import com.example.sem2labandroid4.domain.INoteRepository
import com.example.sem2labandroid4.domain.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDAO: NoteDAO) : INoteRepository {
    override suspend fun addDefaultNote(){
        val defaultNote =
            NoteModel(id = 0, title = "Спасательный круг", noteBody = "Без меня всё развалится")
        noteDAO.insertAll(defaultNote.toEntity())
    }

    override suspend fun getAllNotes(): List<NoteModel> =
        noteDAO.getAll().map { it.toDomain() }

    override suspend fun insetNote(note: NoteModel) {
        noteDAO.insertAll(note.toEntity())
    }

    override suspend fun deleteNote(note: NoteModel) =
        noteDAO.delete(note.toEntity())
}