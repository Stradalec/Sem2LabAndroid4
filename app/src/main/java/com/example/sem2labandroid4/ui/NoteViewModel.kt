package com.example.sem2labandroid4.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sem2labandroid4.domain.INoteRepository
import com.example.sem2labandroid4.domain.model.ModelRepository
import com.example.sem2labandroid4.domain.model.NoteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: ModelRepository) : ViewModel() {
    private val _notes = MutableLiveData<List<NoteModel>>()
    val notes: LiveData<List<NoteModel>> = _notes

    init {
        viewModelScope.launch {
            addDefaultNoteIfNeeded()
            loadNotes()
        }
    }

    private suspend fun addDefaultNoteIfNeeded() {
        withContext(Dispatchers.IO) {
            val allNotes = repository.getAllNotes()
            if (allNotes.isEmpty()) {
                repository.addDefaultNote()
            }
        }
    }

    fun loadNotes() {
        viewModelScope.launch {
            try {
                _notes.value = repository.getAllNotes()
            } catch (e: Exception) {

                _notes.value = null
            }
        }
    }

    fun addNote(note: NoteModel) {
        viewModelScope.launch {
            repository.insetNote(note)
            loadNotes()
        }
    }

    fun deleteNote(note: NoteModel) {
        viewModelScope.launch {
            repository.deleteNote(note)
            loadNotes()
        }
    }
}