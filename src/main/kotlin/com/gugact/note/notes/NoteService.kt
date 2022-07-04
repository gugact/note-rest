package com.gugact.note.notes

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus

@Service
class NoteService(val repo: NoteRepository) {

    fun allNotes() = repo.findAll()

    fun findNote(id: Long) = if (repo.existsById(id)) repo.findById(id) else throw NoteNotFoundException()

    fun updateNote(newNote: Note, id: Long) =
        if (repo.existsById(id)) repo.save(newNote.copy(id = id)) else throw NoteNotFoundException()

    fun deleteNote(id: Long) = if (repo.existsById(id)) repo.deleteById(id) else throw NoteNotFoundException()

    fun createNote(newNote: Note) = repo.save(newNote.copy(id = null))
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class NoteNotFoundException() : Exception("note not found")