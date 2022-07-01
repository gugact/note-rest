package com.gugact.noterest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class NoteRestApplication

fun main(args: Array<String>) {
    runApplication<NoteRestApplication>(*args)
}

@RestController
class HelloController() {
    @GetMapping("/")
    fun hello() = "Hello world"
}