package com.gugact.note.notes

import javax.persistence.*

@Entity
@Table
data class Note(
    @Id
    @SequenceGenerator(
        name = "note_sequence",
        sequenceName = "note_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "note_sequence"
    )
    val id: Long?,
    val title: String,
    val content: String
)