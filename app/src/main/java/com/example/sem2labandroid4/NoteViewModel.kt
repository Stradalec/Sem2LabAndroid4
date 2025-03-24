package com.example.sem2labandroid4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {
    private  val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes
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
    fun loadNotes(){
        viewModelScope.launch {
            try {
                _notes.value = repository.getAllNotes()
            } catch (e: Exception) {

                _notes.value = null
            }
        }
    }
    fun addNote(note: Note) {
        viewModelScope.launch {
            repository.insetNote(note)
            loadNotes()
        }
    }

    fun deleteNote(note: Note){
        viewModelScope.launch {
            repository.deleteNote(note)
            loadNotes()
        }
    }
}