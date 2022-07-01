package com.gugact.noterest.note

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/notes")
class NoteController(val service: NoteService) {

    @GetMapping
    fun findAll() = service.allNotes()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) = service.findNote(id)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun create(@Valid @RequestBody newNote: Note) = service.createNote(newNote)

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    fun update(@RequestBody newNote: Note, @PathVariable id: String) = service.updateNote(newNote)

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = service.deleteNote(id)
}