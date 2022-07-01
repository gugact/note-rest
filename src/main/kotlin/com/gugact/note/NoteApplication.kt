package com.gugact.note

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class NoteApplication

fun main(args: Array<String>) {
	runApplication<NoteApplication>(*args)
}

@RestController
class HelloController() {
	@GetMapping("/")
	fun hello() = "Hello world"
}
