package com.example.sem2labandroid4.data

import com.example.sem2labandroid4.data.local.Note
import com.example.sem2labandroid4.data.repo.NoteRepository
import com.example.sem2labandroid4.domain.model.NoteModel

fun Note.toDomain(): NoteModel {
    return NoteModel(
        id = this.id,
        title = this.title ?: "Без названия",
        noteBody = this.noteBody
    )
}

fun NoteModel.toEntity(): Note {
    return Note(
        id = this.id,
        title = this.title,
        noteBody = this.noteBody
    )
}