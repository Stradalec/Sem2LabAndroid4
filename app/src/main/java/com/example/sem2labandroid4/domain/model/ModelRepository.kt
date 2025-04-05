package com.example.sem2labandroid4.domain.model

import com.example.sem2labandroid4.data.local.NoteDAO
import com.example.sem2labandroid4.data.toDomain
import com.example.sem2labandroid4.data.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ModelRepository @Inject constructor(
    private val noteDAO: NoteDAO
) {

    suspend fun addDefaultNote() {
        val defaultNoteModel = NoteModel(
            title = "Спасательный круг",
            noteBody = "Без меня всё развалится"
        )
        noteDAO.insertAll(defaultNoteModel.toEntity())
    }

    suspend fun getAllNotes(): List<NoteModel> = withContext(Dispatchers.IO) {
        noteDAO.getAll().map { note -> note.toDomain() }
    }

    suspend fun insetNote(noteModel: NoteModel) {
        noteDAO.insertAll(noteModel.toEntity())
    }

    suspend fun deleteNote(noteModel: NoteModel) = withContext(Dispatchers.IO) {
        val noteEntity = noteModel.toEntity()
        noteDAO.delete(noteEntity)
    }
}

