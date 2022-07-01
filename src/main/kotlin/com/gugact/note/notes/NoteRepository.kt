package com.gugact.note.notes

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.UUID

@Repository
class NoteRepository {

    //TODO change so we use database
    private val notes =
        mutableListOf<Note>(Note(UUID.randomUUID().toString(), "First Note Title", "First Note Content"))

    fun findNotes() = notes

    fun findNote(noteId: String) =
        notes.stream().filter { it.id == noteId }.findFirst().orElseThrow { NoteNotFoundException() }

    fun updateNote(newNote: Note) {
        val index = notes.indexOfFirst { it.id == newNote.id }
        if (index >= 0) notes[index] = newNote
        else throw NoteNotFoundException()
    }


    fun createNote(newNote: Note) = newNote.copy(id = UUID.randomUUID().toString()).apply { notes.add(this) }

    fun deleteNote(noteId: String) = if (notes.removeIf { it.id == noteId }) true else throw NoteNotFoundException()
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class NoteNotFoundException : Exception()