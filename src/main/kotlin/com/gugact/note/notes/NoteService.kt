package com.gugact.note.notes

import org.springframework.stereotype.Service

@Service
class NoteService(val repo: NoteRepository) {

    fun allNotes() = repo.findNotes()

    fun findNote(id: String) = repo.findNote(id)

    fun updateNote(newNote: Note) = repo.updateNote(newNote)

    fun deleteNote(id: String) = repo.deleteNote(id)

    fun createNote(newNote: Note) = repo.createNote(newNote)
}